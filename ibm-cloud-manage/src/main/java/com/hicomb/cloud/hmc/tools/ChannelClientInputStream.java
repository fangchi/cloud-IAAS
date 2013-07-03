package com.hicomb.cloud.hmc.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.sshtools.j2ssh.connection.Channel;
import com.sshtools.j2ssh.connection.ChannelEventListener;
import com.sshtools.j2ssh.session.SessionChannelClient;

/**
 * Non-blocking InputStream for reading data from the SessionChannelClient
 * Similar the SessionOutputReader utility class
 */
public class ChannelClientInputStream extends InputStream {
    
    private static org.apache.log4j.Logger LOG =
        org.apache.log4j.Logger.getLogger(ChannelClientInputStream.class);

    private int timeout = 0;

    // use a ByteArrayOutputStream as buffer for the incoming data
    // can't use PipedInputStream because it has a limited buffer only :-(
    private ByteArrayOutputStream buf = new ByteArrayOutputStream (1024);
    
    // intermediate buffer 
    private byte intermediateBuffer [] = new byte[0];
    // read position from the intermediate buffer 
    private int bufferPos = 0;
        
    /**
     * Construct an input stream for the given stream
     * @param session
     */
    public ChannelClientInputStream (SessionChannelClient session,int timeout) throws IOException {
       session.addEventListener(new SessionOutputListener());
       setTimeout (timeout);
    }
    
    /**
     * Break the waiting in waitForData()
     *
     */
    private synchronized void breakWaiting() {
        notifyAll();
    }

    /**
     * The ChannelEventListener to receive event notifications
     */
    class SessionOutputListener implements ChannelEventListener {
        public void onChannelOpen(Channel channel) {
        }

        public void onChannelClose(Channel channel) {
            breakWaiting();
        }

        public void onChannelEOF(Channel channel) {
            // Timeout
            breakWaiting();
        }

        public void onDataSent(Channel channel, byte[] data) {
            // Do nothing
        }

        public void onDataReceived(Channel channel, byte[] data) {
            try {
                synchronized (buf) {
                    buf.write(data);
                }
            } catch (IOException e) {
                LOG.error ("Exception in onDataReceived()",e);
            }
            breakWaiting();
        }
    }

    /**
     * If we have data in the buffers
     * @return
     */
    private boolean hasDataInBuffers () {
        return this.bufferPos<intermediateBuffer.length || buf.size()>0;
    }

    /**
     * Read from the buffers
     * @return The byte read from the buffers or -1 if the buffer is empty
     */
    private int readFromBuffers () {
        while (hasDataInBuffers()) {
            // if we still have byte in the intermediate-buffer then retun it
            if (this.bufferPos<intermediateBuffer.length) {
                return intermediateBuffer[this.bufferPos++];
            }
        
            // put the data from the ByteArray buffer to the intermediate buffer        
            synchronized (buf) {
                this.bufferPos =0;
                this.intermediateBuffer = buf.toByteArray();
                buf.reset();
            }
        }
        // no data in the buffer
        return -1;
    }
    
    /**
     * Get all data from the buffers, and empty them
     * @return
     */
    public synchronized byte[] getAllDataFromBuffers() throws IOException {
        synchronized (buf) {
            ByteArrayOutputStream allData = new ByteArrayOutputStream (intermediateBuffer.length+buf.size());
            if (bufferPos<intermediateBuffer.length) {
                allData.write (intermediateBuffer, bufferPos,intermediateBuffer.length-bufferPos);
                bufferPos = 0;
                intermediateBuffer = new byte[0];
            }
            allData.write (buf.toByteArray());
            buf.reset();
            return allData.toByteArray();
        }        
    }
    
    /* (non-Javadoc)
     * @see java.io.InputStream#read()
     */
    public synchronized int read() throws IOException {
        int data = readFromBuffers();
        if (data!=-1) return data;
        
        // no data in buffer, so wait
        try {
            wait (this.timeout);                    
        } 
        catch (InterruptedException e) {
            throw new IOException ("InterruptedException during wait:"+e.getMessage());
        }
        
        return readFromBuffers();
    }

    /**
     * @return The wait timout for the read() method
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * @param i Set the wait timout for the read() method
     */
    public void setTimeout(int i) {
        timeout = i;
    }

}

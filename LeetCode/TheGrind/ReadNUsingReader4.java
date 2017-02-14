public class ReadNUsingReader4 //extends Reader4
{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

     /*ELEGANT SOLUTION!
     Since read can be called multiple times, we need to make sure we don't lose data read but not used.
     For eg: File = {a,b,c,d,e,f,g,h,i}
     Read sequence:
     read(buf,1) -> Read4 reads 4 items, but Read returns only 1
     read(buf, 2) -> Read4 not called, since we have overflow of 3 and we just need 2
     read(buf 8) -> Overflow of 1 used, then read4 called once - all 4 consumed, then read4 called again and read till EOF
     */

    //Buffer and pointers to keep track of unused characters:
    //bufferPointer : next lement to be consumed from the buffer | bufferCount : number of valid elements left in the buffer
    char[] buffer=new char[4];
    int bufferPointer=0, bufferCount=0;

    public int read(char[] buf, int n)
    {
        int readCount=0;

        //We read and copy elements into buf till the time we run out of characters in file or we consume n characters.
        while(readCount<n)
        {
            //If buffer is empty, read in 4/available elements
            if(bufferPointer==0)
                bufferCount=read4(buffer);

            //EOF!
            if(bufferCount==0)
                break;

            //While we have more chars to read and there are valid chars in the buffer, copy into buf
            while(readCount<n && bufferPointer<bufferCount)
                buf[readCount++]=buffer[bufferPointer++];

            //If we have consumed all available data from buffer, reset bufferPointer to 0
            if(bufferPointer>=bufferCount)
                bufferPointer=0;
        }
        return readCount;
    }
}

import java.util.*;
import java.lang.*;

class AllValidIPAddresses
{
    public static List<String> generateAllValidIPAddresses(String input)
    {
        List<String> addressList=new ArrayList<String>();
        if(input==null || input.length()<4)
            return addressList;

        for(int i=1;i<4 && i<input.length();i++)
        {
            String first=input.substring(0,i);
            if(Integer.parseInt(first)>=0 && Integer.parseInt(first)<=255)
            {
                for(int j=1;j<4 && i+j<input.length();j++)
                {
                    String second=input.substring(i, i+j);
                    if(Integer.parseInt(second)>=0 && Integer.parseInt(second)<=255)
                    {
                        for(int k=1;k<4 && i+j+k<input.length();k++)
                        {
                            String third=input.substring(i+j, i+j+k);
                            if(Integer.parseInt(third)>=0 && Integer.parseInt(third)<=255)
                            {
                                String fourth=input.substring(i+j+k);
                                if(Integer.parseInt(fourth)>=0 && Integer.parseInt(fourth)<=255)
                                {
                                    String ipAddress=first+"."+second+"."+third+"."+fourth;
                                    addressList.add(ipAddress);
                                }
                            }
                        }
                    }
                }
            }
        }
        return addressList;
    }

    public static void main(String args[])
    {

        String ip1="19216811";
        System.out.println("IP String: "+ip1+"\nValid IP Addresses:\n"+Arrays.toString((generateAllValidIPAddresses(ip1)).toArray())+"\n");

        String ip2="192168122311";
        System.out.println("IP String: "+ip2+"\nValid IP Addresses:\n"+Arrays.toString((generateAllValidIPAddresses(ip2)).toArray())+"\n");

        String ip3="111111";
        System.out.println("IP String: "+ip3+"\nValid IP Addresses:\n"+Arrays.toString((generateAllValidIPAddresses(ip3)).toArray())+"\n");

        String ip4="0";
        System.out.println("IP String: "+ip4+"\nValid IP Addresses:\n"+Arrays.toString((generateAllValidIPAddresses(ip4)).toArray())+"\n");

        String ip5="1234";
        System.out.println("IP String: "+ip5+"\nValid IP Addresses:\n"+Arrays.toString((generateAllValidIPAddresses(ip5)).toArray())+"\n");

    }
}

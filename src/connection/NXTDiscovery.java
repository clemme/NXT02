package connection;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class NXTDiscovery {
	public static void main(String[] args) throws NXTCommException {
		NXTComm nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		NXTInfo info[] = nxtComm.search(null);
		for(NXTInfo i : info) {
			
			System.out.println("Name: " + i.name + " , address: " + i.deviceAddress);
		}
	}
}

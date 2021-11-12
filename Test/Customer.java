import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class Customer {
	
	private String id = "";
	
	private void generateID() {
		
		// generating Least Significant 64 Bits 
		Random rand = new Random();
		long r63 = rand.nextLong() & 0x3FFFFFFFFFFFFFFFL;
		long b3flg = 0x8000000000000000L;
		long leastSig64 = r63+b3flg;
		
		// generate Most Significant 64 Bits
		LocalDateTime start =  LocalDateTime.of(1400, 10, 15, 0, 0);
		Duration durr = Duration.between(start, LocalDateTime.now());
		long seconds = durr.getSeconds();
		long nanos = durr.getNano();
		long UuidTime100Nanos = seconds * 10000000 + nanos * 100;
		long least12SigBit = (UuidTime100Nanos & 0x000000000000FFFFL) >> 4;
		long version = 1 << 12;
		long mostSig64 = (UuidTime100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SigBit;
		
		
		// generating UUID w/least & most sig 64 bit representations
		UUID uid = new UUID(leastSig64, mostSig64);
		
		// setting private id to uid
		id = uid.toString();
		
	}
	
	public String getID() {
		generateID();
		return id;
	}
}

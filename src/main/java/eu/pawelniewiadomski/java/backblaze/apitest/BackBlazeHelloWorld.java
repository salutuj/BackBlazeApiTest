package eu.pawelniewiadomski.java.backblaze.apitest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import synapticloop.b2.B2ApiClient;
import synapticloop.b2.BucketType;
import synapticloop.b2.exception.B2ApiException;
import synapticloop.b2.response.B2BucketResponse;


public class BackBlazeHelloWorld {
	
	public static void main(String[] args) throws B2ApiException, IOException {
		String b2AccountId = ""; // your b2 account ID
		String b2ApplicationKey = ""; // your b2 application Key

		try {
			B2ApiClient b2ApiClient = new B2ApiClient();
			b2ApiClient.authenticate(b2AccountId, b2ApplicationKey);

			b2ApiClient.listBuckets().forEach(System.out::println);
			
			// now create a private bucket
			//B2BucketResponse createPrivateBucket = b2ApiClient.createBucket("super-secret-bucket" , BucketType.allPrivate);

			// or a public one
			//B2BucketResponse createPublicBucket = b2ApiClient.createBucket("everyone-has-access" , BucketType.allPublic);

			// upload a file to the private bucket
			//apiclient uploadFile(createPrivateBucket.getBucketId(), "myfile.txt", new File("/tmp/temporary-file.txt"));

		} catch(B2ApiException | IOException ex) {
			ex.printStackTrace();
		}
	}
}

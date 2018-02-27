import com.amazonaws.services.cloudfront.*;
import com.amazonaws.services.cloudfront.model.CreateInvalidationRequest;
import com.amazonaws.services.cloudfront.model.InvalidationBatch;
import com.amazonaws.services.cloudfront.model.Paths;

public class Invalidate {
	  public static void main(String[] args) {
		  String distributionID = "E3THQGTHS4FMLD";
		  AmazonCloudFrontClient client = new AmazonCloudFrontClient();
		  Paths invalidation_paths = new Paths().withItems("/*").withQuantity(1);
		  CreateInvalidationRequest invalidation = new CreateInvalidationRequest(distributionID, new InvalidationBatch(invalidation_paths,"test"));
		  System.out.println(client.createInvalidation(invalidation).toString());  	  
    }
}
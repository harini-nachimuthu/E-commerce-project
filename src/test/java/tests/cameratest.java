package tests;

import org.testng.annotations.Test;

import base.basemethod;
import pages.camerapage;

public class cameratest extends basemethod{
  @Test(priority=9,description="Comparing two cameras specification and removing them")
  public void cameracompare() throws InterruptedException {
	  camerapage cam=new camerapage(driver);
	  cam.camera1()
	  .camera2()
	  .remove()
	  .productinfocollect();
  }
}

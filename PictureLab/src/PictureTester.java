/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	public static void testMirrorVerticalRightToLeft() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVerticalRightToLeft();
		caterpillar.explore();
	}

	public static void testMirrorHorizontal() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorHorizontal();
		caterpillar.explore();
	}

	public static void testMirrorHorizontalBottomTop() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorHorizontalBottomTop();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	public static void mirrorSnowman() {
		Picture snowman = new Picture("snowman.jpg");
		snowman.mirrorArms();
		snowman.explore();
	}
	
	public static void mirrorGull() {
		Picture gull = new Picture("seagull.jpg");
		gull.mirrorGull();
		gull.explore();
	}
	
	public static void testDiagonalMirror() {
		Picture beach = new Picture("beach.jpg");
		beach.diagonalMirror();
		beach.explore();
	}

	/** Main method for testing.  Every class can have a main
	 * method in Java */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run

		//Assignment specific tests:
		//mirrorGull();
		//testMirrorVertical();
		//testMirrorVerticalRightToLeft();
		//testMirrorHorizontalBottomTop();
		//testMirrorHorizontal();
		//mirrorSnowman();
		//testDiagonalMirror();
		
		//testZeroBlue();
		//testKeepOnlyBlue();
		//testKeepOnlyRed();
		//testKeepOnlyGreen();
		//testNegate();
		//testGrayscale();
		//testFixUnderwater();
		//testMirrorTemple();
		//testMirrorArms();
		//testMirrorDiagonal();
		//testCollage();
		//testCopy();
		//testEdgeDetection();
		//testEdgeDetection2();
		//testChromakey();
		//testEncodeAndDecode();
		//testGetCountRedOverValue(250);
		//testSetRedToHalfValueInTopHalf();
		//testClearBlueOverValue(200);
		//testGetAverageForColumn(0);
	}
}
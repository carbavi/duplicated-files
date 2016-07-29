package com.carbavi.core.utils;

import com.carbavi.core.utils.service.impl.CompareFilesImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import junit.framework.Assert;
import junit.framework.TestCase;

public class CompareFilesTest extends TestCase {
    
    private CompareFilesImpl compare;
    private Path doc1_content1;
    private Path doc2_content1;
    private Path doc3_content3;
    private Path rpm1_content1;
    private Path img1_image1;
    private Path img2_image2;
    private Path img3_image1;
    private Path mp3_01_content1;
    private Path mp3_02_content2;
    private Path mp3_03_content1;
    private Path mp3_04_content2;

    public CompareFilesTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        compare = new CompareFilesImpl();
        doc1_content1 = Paths.get("target/test-classes/files/01_a_content.txt");
        doc2_content1 = Paths.get("target/test-classes/files/02_a_content.txt");
        doc3_content3 = Paths.get("target/test-classes/files/03_b_content.txt");
        rpm1_content1 = Paths.get("target/test-classes/files/04_a_content_txt.rpm");
        img1_image1 = Paths.get("target/test-classes/files/img1_image1.jpg");
        img2_image2 = Paths.get("target/test-classes/files/img2_image2.jpg");
        img3_image1 = Paths.get("target/test-classes/files/img3_image1.jpg");
        mp3_01_content1 = Paths.get("target/test-classes/files/mp3_01_content1.mp3");
        mp3_02_content2 = Paths.get("target/test-classes/files/mp3_02_content2.mp3");
        mp3_03_content1 = Paths.get("target/test-classes/files/mp3_03_content1.mp3");
        mp3_04_content2 = Paths.get("target/test-classes/files/mp3_04_content2.wav");
    }

    public void testNullFiles() {
        Assert.assertFalse(compare.areEqual(null, null));
    }

    public void testSameContent() {
        Assert.assertTrue(compare.areEqual(doc1_content1, doc2_content1));
        Assert.assertTrue(compare.areEqual(img1_image1, img3_image1));
        Assert.assertTrue(compare.areEqual(mp3_01_content1, mp3_03_content1));
    }

    public void testSameSizeDifferentContent() {
        Assert.assertFalse(compare.areEqual(doc1_content1, doc3_content3));
        Assert.assertFalse(compare.areEqual(doc3_content3, rpm1_content1));
    }

    public void testSameContentDifferentExtension() {
        Assert.assertTrue(compare.areEqual(doc1_content1, rpm1_content1));
        Assert.assertTrue(compare.areEqual(doc2_content1, rpm1_content1));
        Assert.assertTrue(compare.areEqual(mp3_02_content2, mp3_04_content2));
    }
    
    public void testDifferentSize() {
        Assert.assertFalse(compare.areEqual(img1_image1, img2_image2));
        Assert.assertFalse(compare.areEqual(img3_image1, img2_image2));
        Assert.assertFalse(compare.areEqual(mp3_01_content1, mp3_02_content2));
        Assert.assertFalse(compare.areEqual(mp3_03_content1, mp3_04_content2));
    }
    
}

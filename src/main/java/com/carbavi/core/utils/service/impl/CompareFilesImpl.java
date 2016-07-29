package com.carbavi.core.utils.service.impl;

import com.carbavi.core.utils.service.CompareFiles;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * @author developer
 */
public class CompareFilesImpl implements CompareFiles {

    private static final Logger LOGGER = Logger.getLogger(CompareFilesImpl.class);

    @Override
    public boolean areEqual(Path path1, Path path2) {
        return (path1 == null || path2 == null) ?
                false : compareFiles(path1.toFile(), path2.toFile());
    }
    
    private boolean compareFiles(File file1, File file2) {
        return sameSize(file1, file2) && sameContent(file1, file2);
    }
    
    private boolean sameSize(File file1, File file2) {
        assert(file1 != null);
        assert(file2 != null);
        return file1.length() == file2.length();
    }
    
    private boolean sameContent(File file1, File file2) {
        assert(file1 != null);
        assert(file2 != null);        
        try {
            return FileUtils.contentEquals(file1, file2);
        } catch (IOException ex) {
            LOGGER.warn(String.format("File content of files %s and %scouldn't be compared",
                    file1.getAbsolutePath(), file2.getAbsolutePath()));
            return false;
        }
    }

}

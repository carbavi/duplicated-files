/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbavi.core.utils.service;

import java.nio.file.Path;

/**
 *
 * @author developer
 */
public interface CompareFiles {
    
    boolean areEqual(Path path1, Path path2);
    
}

package org.example;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Vector creation test")
@IncludeTags("CreationTest")
@SelectClasses(VectorTest.class)
public class CreationTestSuite {}

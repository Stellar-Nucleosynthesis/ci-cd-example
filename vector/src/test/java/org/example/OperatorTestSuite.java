package org.example;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Vector operator methods test")
@IncludeTags("OperatorTest")
@SelectClasses(VectorTest.class)
public class OperatorTestSuite {}

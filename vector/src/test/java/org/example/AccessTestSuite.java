package org.example;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Vector access methods test")
@IncludeTags("AccessTest")
@SelectClasses(VectorTest.class)
public class AccessTestSuite {
}

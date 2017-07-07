/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.bridge.ext;

import org.junit.Assume;
import org.junit.Test;

/**
 *
 * @author Kyle Stiemann
 */
public class NecessaryForCITest {

	@Test
	public void runNecessaryForCITest() {

		// This (skipped) test is needed for Bamboo to build and pass the project because newer branches include tests.
		Assume.assumeTrue(false);
	}
}

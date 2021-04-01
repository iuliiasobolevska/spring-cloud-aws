/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.awspring.cloud.v3.autoconfigure.parameterstore;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.ssm.SsmClient;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for {@link AwsParameterStoreBootstrapConfiguration}.
 *
 * @author Matej Nedic
 * @author Eddú Meléndez
 */
class AwsParameterStoreBootstrapConfigurationTest {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(AwsParameterStoreBootstrapConfiguration.class));

	@Test
	void testMissingAutoConfiguration() {
		this.contextRunner.withPropertyValues("spring.cloud.aws.parameterstore.enabled:false").run(context -> {
			assertThat(context).doesNotHaveBean(SsmClient.class);
		});
	}

}
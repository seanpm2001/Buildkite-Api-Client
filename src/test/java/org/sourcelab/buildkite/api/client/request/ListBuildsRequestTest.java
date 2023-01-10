/**
 * Copyright 2023 SourceLab.org https://github.com/SourceLabOrg/Buildkite-Api-Client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.sourcelab.buildkite.api.client.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListBuildsRequestTest {

    @Test
    void getPath_allOrgs()
    {
        // Call method under test.
        final String path = new ListBuildsRequest(BuildFilters.newBuilder()
            .build()
        ).getPath();
        assertEquals("/v2/builds", path);
    }

    @Test
    void getPath_singleOrg()
    {
        // Call method under test.
        final String path = new ListBuildsRequest(BuildFilters.newBuilder()
            .withOrganization("my-org-id")
            .build()
        ).getPath();
        assertEquals("/v2/organizations/my-org-id/builds", path);
    }

    @Test
    void getPath_singlePipeline()
    {
        // Call method under test.
        final String path = new ListBuildsRequest(BuildFilters.newBuilder()
                .withPipeline("my-org-id", "my-pipeline")
                .build()
        ).getPath();
        assertEquals("/v2/organizations/my-org-id/pipelines/my-pipeline/builds", path);
    }

    @Test
    void getPath_singleBuild()
    {
        // Call method under test.
        final String path = new ListBuildsRequest(BuildFilters.newBuilder()
                .withBuildNumber("my-org-id", "my-pipeline", 25L)
                .build()
        ).getPath();
        assertEquals("/v2/organizations/my-org-id/pipelines/my-pipeline/builds/25", path);
    }
}
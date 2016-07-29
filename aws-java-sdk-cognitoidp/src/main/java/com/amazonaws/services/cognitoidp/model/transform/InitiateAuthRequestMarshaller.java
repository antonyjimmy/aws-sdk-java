/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not
 * use this file except in compliance with the License. A copy of the License is
 * located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cognitoidp.model.transform;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidp.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.protocol.json.*;

/**
 * InitiateAuthRequest Marshaller
 */
public class InitiateAuthRequestMarshaller implements
        Marshaller<Request<InitiateAuthRequest>, InitiateAuthRequest> {

    private final SdkJsonProtocolFactory protocolFactory;

    public InitiateAuthRequestMarshaller(SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<InitiateAuthRequest> marshall(
            InitiateAuthRequest initiateAuthRequest) {

        if (initiateAuthRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<InitiateAuthRequest> request = new DefaultRequest<InitiateAuthRequest>(
                initiateAuthRequest, "AWSCognitoIdentityProvider");
        request.addHeader("X-Amz-Target",
                "AWSCognitoIdentityProviderService.InitiateAuth");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory
                    .createGenerator();

            jsonGenerator.writeStartObject();

            if (initiateAuthRequest.getAuthFlow() != null) {
                jsonGenerator.writeFieldName("AuthFlow").writeValue(
                        initiateAuthRequest.getAuthFlow());
            }

            java.util.Map<String, String> authParametersMap = initiateAuthRequest
                    .getAuthParameters();
            if (authParametersMap != null) {
                jsonGenerator.writeFieldName("AuthParameters");
                jsonGenerator.writeStartObject();

                for (Map.Entry<String, String> authParametersMapValue : authParametersMap
                        .entrySet()) {
                    if (authParametersMapValue.getValue() != null) {
                        jsonGenerator.writeFieldName(authParametersMapValue
                                .getKey());

                        jsonGenerator.writeValue(authParametersMapValue
                                .getValue());
                    }
                }
                jsonGenerator.writeEndObject();
            }

            java.util.Map<String, String> clientMetadataMap = initiateAuthRequest
                    .getClientMetadata();
            if (clientMetadataMap != null) {
                jsonGenerator.writeFieldName("ClientMetadata");
                jsonGenerator.writeStartObject();

                for (Map.Entry<String, String> clientMetadataMapValue : clientMetadataMap
                        .entrySet()) {
                    if (clientMetadataMapValue.getValue() != null) {
                        jsonGenerator.writeFieldName(clientMetadataMapValue
                                .getKey());

                        jsonGenerator.writeValue(clientMetadataMapValue
                                .getValue());
                    }
                }
                jsonGenerator.writeEndObject();
            }
            if (initiateAuthRequest.getClientId() != null) {
                jsonGenerator.writeFieldName("ClientId").writeValue(
                        initiateAuthRequest.getClientId());
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length",
                    Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}

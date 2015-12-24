package org.sopt.annotations.network;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.sopt.annotations.domain.VersionInfo;
import org.springframework.http.client.OkHttpClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Rest(rootUrl = "http://sopt.org", converters = GsonHttpMessageConverter.class, requestFactory = OkHttpClientHttpRequestFactory.class)
public interface Api {

    @Get(value = "/api/version/current")
    VersionInfo getVersionInfoFromServer();
}

package ru.sazonov.assertions;

import org.apache.http.HttpStatus;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import ru.sazonov.clients.RestResponse;

public class ResponseAssertion<T> extends AbstractAssert<ResponseAssertion<T>, RestResponse<T>> {
    private final SoftAssertions softAssertions;
    private final RestResponse<T> restResponse;

    public ResponseAssertion(RestResponse<T> restResponse) {
        super(restResponse, ResponseAssertion.class);
        this.restResponse = restResponse;
        this.softAssertions = new SoftAssertions();
    }

    public static <T> ResponseAssertion<T> assertResponse(RestResponse<T> response) {
        return new ResponseAssertion<>(response);
    }

    public ResponseAssertion<T> isOk() {
        softAssertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        return this;
    }

    public ResponseAssertion<T> isCreated() {
        softAssertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.SC_CREATED);
        return this;
    }

    public ResponseAssertion<T> assertBody(MatchesAssertion<T> matchesAssertion) {
        matchesAssertion.doAssert(restResponse.extractBody(), softAssertions);
        return this;
    }

    public ResponseAssertion<?> hasStatusCode(int expectedStatusCode) {
        isNotNull();
        softAssertions.assertThat(actual.getStatusCode())
                .as("HTTP Status Code")
                .isEqualTo(expectedStatusCode);
        return this;
    }

    public void assertAll() {
        softAssertions.assertAll();
    }

    @FunctionalInterface
    public interface MatchesAssertion<T> {
        void doAssert(T body, SoftAssertions softAssertions);
    }
}

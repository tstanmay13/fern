/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.object.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.object.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PostRootRequest.Builder.class)
public final class PostRootRequest {
    private final Bar bar;

    private final String foo;

    private final Map<String, Object> additionalProperties;

    private PostRootRequest(Bar bar, String foo, Map<String, Object> additionalProperties) {
        this.bar = bar;
        this.foo = foo;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("bar")
    public Bar getBar() {
        return bar;
    }

    @JsonProperty("foo")
    public String getFoo() {
        return foo;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PostRootRequest && equalTo((PostRootRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PostRootRequest other) {
        return bar.equals(other.bar) && foo.equals(other.foo);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.bar, this.foo);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BarStage builder() {
        return new Builder();
    }

    public interface BarStage {
        FooStage bar(@NotNull Bar bar);

        Builder from(PostRootRequest other);
    }

    public interface FooStage {
        _FinalStage foo(@NotNull String foo);
    }

    public interface _FinalStage {
        PostRootRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BarStage, FooStage, _FinalStage {
        private Bar bar;

        private String foo;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(PostRootRequest other) {
            bar(other.getBar());
            foo(other.getFoo());
            return this;
        }

        @java.lang.Override
        @JsonSetter("bar")
        public FooStage bar(@NotNull Bar bar) {
            this.bar = Objects.requireNonNull(bar, "bar must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("foo")
        public _FinalStage foo(@NotNull String foo) {
            this.foo = Objects.requireNonNull(foo, "foo must not be null");
            return this;
        }

        @java.lang.Override
        public PostRootRequest build() {
            return new PostRootRequest(bar, foo, additionalProperties);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = Bar.Builder.class)
    public static final class Bar {
        private final String foo;

        private final Map<String, Object> additionalProperties;

        private Bar(String foo, Map<String, Object> additionalProperties) {
            this.foo = foo;
            this.additionalProperties = additionalProperties;
        }

        /**
         * @return lorem ipsum
         */
        @JsonProperty("foo")
        public String getFoo() {
            return foo;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof Bar && equalTo((Bar) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(Bar other) {
            return foo.equals(other.foo);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.foo);
        }

        @java.lang.Override
        public String toString() {
            return ObjectMappers.stringify(this);
        }

        public static FooStage builder() {
            return new Builder();
        }

        public interface FooStage {
            /**
             * <p>lorem ipsum</p>
             */
            _FinalStage foo(@NotNull String foo);

            Builder from(Bar other);
        }

        public interface _FinalStage {
            Bar build();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder implements FooStage, _FinalStage {
            private String foo;

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            @java.lang.Override
            public Builder from(Bar other) {
                foo(other.getFoo());
                return this;
            }

            /**
             * <p>lorem ipsum</p>
             * <p>lorem ipsum</p>
             * @return Reference to {@code this} so that method calls can be chained together.
             */
            @java.lang.Override
            @JsonSetter("foo")
            public _FinalStage foo(@NotNull String foo) {
                this.foo = Objects.requireNonNull(foo, "foo must not be null");
                return this;
            }

            @java.lang.Override
            public Bar build() {
                return new Bar(foo, additionalProperties);
            }
        }
    }
}

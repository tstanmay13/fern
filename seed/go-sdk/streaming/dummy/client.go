// Code generated by Fern. DO NOT EDIT.

package dummy

import (
	context "context"
	v2 "github.com/fern-api/stream-go/v2"
	core "github.com/fern-api/stream-go/v2/core"
	internal "github.com/fern-api/stream-go/v2/internal"
	option "github.com/fern-api/stream-go/v2/option"
	http "net/http"
)

type Client struct {
	WithRawResponse *RawClient

	baseURL string
	caller  *internal.Caller
	header  http.Header
}

func NewClient(opts ...option.RequestOption) *Client {
	options := core.NewRequestOptions(opts...)
	return &Client{
		WithRawResponse: NewRawClient(options),
		baseURL:         options.BaseURL,
		caller: internal.NewCaller(
			&internal.CallerParams{
				Client:      options.HTTPClient,
				MaxAttempts: options.MaxAttempts,
			},
		),
		header: options.ToHeader(),
	}
}

func (c *Client) GenerateStream(
	ctx context.Context,
	request *v2.GenerateStreamRequest,
	opts ...option.RequestOption,
) (*core.Stream[v2.StreamResponse], error) {
	options := core.NewRequestOptions(opts...)
	baseURL := internal.ResolveBaseURL(
		options.BaseURL,
		c.baseURL,
		"",
	)
	endpointURL := baseURL + "/generate-stream"
	headers := internal.MergeHeaders(
		c.header.Clone(),
		options.ToHeader(),
	)
	streamer := internal.NewStreamer[v2.StreamResponse](c.caller)
	return streamer.Stream(
		ctx,
		&internal.StreamParams{
			URL:             endpointURL,
			Method:          http.MethodPost,
			Headers:         headers,
			MaxAttempts:     options.MaxAttempts,
			BodyProperties:  options.BodyProperties,
			QueryParameters: options.QueryParameters,
			Client:          options.HTTPClient,
			Request:         request,
		},
	)
}

func (c *Client) Generate(
	ctx context.Context,
	request *v2.Generateequest,
	opts ...option.RequestOption,
) (*v2.StreamResponse, error) {
	response, err := c.WithRawResponse.Generate(
		ctx,
		request,
		opts...,
	)
	if err != nil {
		return nil, err
	}
	return response.Body, nil
}

// Code generated by Fern. DO NOT EDIT.

package responseproperty

type WithDocs struct {
	Docs string `json:"docs" url:"docs"`
}

type OptionalWithDocs = *WithDocs

type Movie struct {
	Id   string `json:"id" url:"id"`
	Name string `json:"name" url:"name"`
}

type Response struct {
	Metadata map[string]string `json:"metadata" url:"metadata"`
	Docs     string            `json:"docs" url:"docs"`
	Data     *Movie            `json:"data" url:"data"`
}

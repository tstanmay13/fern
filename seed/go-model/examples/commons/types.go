// Code generated by Fern. DO NOT EDIT.

package commons

type Tag = string

type Metadata struct {
	Id         string            `json:"id" url:"id"`
	Data       map[string]string `json:"data,omitempty" url:"data,omitempty"`
	JsonString *string           `json:"jsonString,omitempty" url:"jsonString,omitempty"`
}

type EventInfo struct {
	Type     string
	Metadata Metadata
	Tag      Tag
}

type Data struct {
	Type   string
	String string
	Base64 []byte
}

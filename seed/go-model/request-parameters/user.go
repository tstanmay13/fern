// Code generated by Fern. DO NOT EDIT.

package requestparameters

type User struct {
	Name string   `json:"name" url:"name"`
	Tags []string `json:"tags" url:"tags"`
}

type NestedUser struct {
	Name string `json:"name" url:"name"`
	User *User  `json:"user" url:"user"`
}

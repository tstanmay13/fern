// Code generated by Fern. DO NOT EDIT.

package fileupload

import (
	fmt "fmt"
)

type Id = string

type MyObjectWithOptional struct {
	Prop         string  `json:"prop" url:"prop"`
	OptionalProp *string `json:"optionalProp,omitempty" url:"optionalProp,omitempty"`
}

type MyAliasObject = *MyObject

type MyCollectionAliasObject = []*MyObject

type MyObject struct {
	Foo string `json:"foo" url:"foo"`
}

type ObjectType string

const (
	ObjectTypeFoo = "FOO"
	ObjectTypeBar = "BAR"
)

func NewObjectTypeFromString(s string) (ObjectType, error) {
	switch s {
	case "FOO":
		return ObjectTypeFoo, nil
	case "BAR":
		return ObjectTypeBar, nil
	}
	var t ObjectType
	return "", fmt.Errorf("%s is not a valid %T", s, t)
}

func (o ObjectType) Ptr() *ObjectType {
	return &o
}

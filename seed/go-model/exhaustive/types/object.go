// Code generated by Fern. DO NOT EDIT.

package types

import (
	uuid "github.com/google/uuid"
	time "time"
)

type ObjectWithOptionalField struct {
	// This is a rather long descriptor of this single field in a more complex type. If you ask me I think this is a pretty good description for this field all things considered.
	String   *string        `json:"string,omitempty" url:"string,omitempty"`
	Integer  *int           `json:"integer,omitempty" url:"integer,omitempty"`
	Long     *int64         `json:"long,omitempty" url:"long,omitempty"`
	Double   *float64       `json:"double,omitempty" url:"double,omitempty"`
	Bool     *bool          `json:"bool,omitempty" url:"bool,omitempty"`
	Datetime *time.Time     `json:"datetime,omitempty" url:"datetime,omitempty"`
	Date     *time.Time     `json:"date,omitempty" url:"date,omitempty"`
	Uuid     *uuid.UUID     `json:"uuid,omitempty" url:"uuid,omitempty"`
	Base64   []byte         `json:"base64,omitempty" url:"base64,omitempty"`
	List     []string       `json:"list,omitempty" url:"list,omitempty"`
	Set      []string       `json:"set,omitempty" url:"set,omitempty"`
	Map      map[int]string `json:"map,omitempty" url:"map,omitempty"`
	Bigint   *string        `json:"bigint,omitempty" url:"bigint,omitempty"`
}

type ObjectWithRequiredField struct {
	String string `json:"string" url:"string"`
}

type ObjectWithMapOfMap struct {
	Map map[string]map[string]string `json:"map" url:"map"`
}

type NestedObjectWithOptionalField struct {
	String       *string                  `json:"string,omitempty" url:"string,omitempty"`
	NestedObject *ObjectWithOptionalField `json:"NestedObject,omitempty" url:"NestedObject,omitempty"`
}

type NestedObjectWithRequiredField struct {
	String       string                   `json:"string" url:"string"`
	NestedObject *ObjectWithOptionalField `json:"NestedObject" url:"NestedObject"`
}

type DoubleOptional struct {
	OptionalAlias *OptionalAlias `json:"optionalAlias,omitempty" url:"optionalAlias,omitempty"`
}

type OptionalAlias = *string

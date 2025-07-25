// Code generated by Fern. DO NOT EDIT.

package unions

type GetShapeRequest struct {
	Id string `json:"id" url:"id"`
}

type Shape struct {
	Type   string
	Id     string
	Circle Circle
	Square Square
}

type Circle struct {
	Radius float64 `json:"radius" url:"radius"`
}

type Square struct {
	Length float64 `json:"length" url:"length"`
}

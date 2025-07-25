# This file was auto-generated by Fern from our API Definition.

import typing

import pydantic
import typing_extensions
from ....core.pydantic_utilities import IS_PYDANTIC_V2, UniversalBaseModel
from ....core.serialization import FieldMetadata


class Dog(UniversalBaseModel):
    name: str
    likes_to_woof: typing_extensions.Annotated[bool, FieldMetadata(alias="likesToWoof")]

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(frozen=True)  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True
            extra = pydantic.Extra.ignore

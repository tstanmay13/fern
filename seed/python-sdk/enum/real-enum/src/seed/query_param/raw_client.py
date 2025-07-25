# This file was auto-generated by Fern from our API Definition.

import typing
from json.decoder import JSONDecodeError

from ..core.api_error import ApiError
from ..core.client_wrapper import AsyncClientWrapper, SyncClientWrapper
from ..core.http_response import AsyncHttpResponse, HttpResponse
from ..core.request_options import RequestOptions
from ..types.color_or_operand import ColorOrOperand
from ..types.operand import Operand


class RawQueryParamClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper
    
    def send(self, *, operand: Operand, operand_or_color: ColorOrOperand, maybe_operand: typing.Optional[Operand] = None, maybe_operand_or_color: typing.Optional[ColorOrOperand] = None, request_options: typing.Optional[RequestOptions] = None) -> HttpResponse[None]:
        """
        Parameters
        ----------
        operand : Operand
        
        operand_or_color : ColorOrOperand
        
        maybe_operand : typing.Optional[Operand]
        
        maybe_operand_or_color : typing.Optional[ColorOrOperand]
        
        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.
        
        Returns
        -------
        HttpResponse[None]
        """
        _response = self._client_wrapper.httpx_client.request(
            "query",method="POST",
            params={"operand": operand, "maybeOperand": maybe_operand, "operandOrColor": operand_or_color, "maybeOperandOrColor": maybe_operand_or_color, }
            ,
            request_options=request_options,)
        try:
            if 200 <= _response.status_code < 300:
                return HttpResponse(response=_response, data=None)
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response.text)
        raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response_json)
    
    def send_list(self, *, operand: typing.Union[Operand, typing.Sequence[Operand]], operand_or_color: typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]], maybe_operand: typing.Optional[typing.Union[Operand, typing.Sequence[Operand]]] = None, maybe_operand_or_color: typing.Optional[typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]]] = None, request_options: typing.Optional[RequestOptions] = None) -> HttpResponse[None]:
        """
        Parameters
        ----------
        operand : typing.Union[Operand, typing.Sequence[Operand]]
        
        operand_or_color : typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]]
        
        maybe_operand : typing.Optional[typing.Union[Operand, typing.Sequence[Operand]]]
        
        maybe_operand_or_color : typing.Optional[typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]]]
        
        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.
        
        Returns
        -------
        HttpResponse[None]
        """
        _response = self._client_wrapper.httpx_client.request(
            "query-list",method="POST",
            params={"operand": operand, "maybeOperand": maybe_operand, "operandOrColor": operand_or_color, "maybeOperandOrColor": maybe_operand_or_color, }
            ,
            request_options=request_options,)
        try:
            if 200 <= _response.status_code < 300:
                return HttpResponse(response=_response, data=None)
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response.text)
        raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response_json)
class AsyncRawQueryParamClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper
    
    async def send(self, *, operand: Operand, operand_or_color: ColorOrOperand, maybe_operand: typing.Optional[Operand] = None, maybe_operand_or_color: typing.Optional[ColorOrOperand] = None, request_options: typing.Optional[RequestOptions] = None) -> AsyncHttpResponse[None]:
        """
        Parameters
        ----------
        operand : Operand
        
        operand_or_color : ColorOrOperand
        
        maybe_operand : typing.Optional[Operand]
        
        maybe_operand_or_color : typing.Optional[ColorOrOperand]
        
        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.
        
        Returns
        -------
        AsyncHttpResponse[None]
        """
        _response = await self._client_wrapper.httpx_client.request(
            "query",method="POST",
            params={"operand": operand, "maybeOperand": maybe_operand, "operandOrColor": operand_or_color, "maybeOperandOrColor": maybe_operand_or_color, }
            ,
            request_options=request_options,)
        try:
            if 200 <= _response.status_code < 300:
                return AsyncHttpResponse(response=_response, data=None)
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response.text)
        raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response_json)
    
    async def send_list(self, *, operand: typing.Union[Operand, typing.Sequence[Operand]], operand_or_color: typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]], maybe_operand: typing.Optional[typing.Union[Operand, typing.Sequence[Operand]]] = None, maybe_operand_or_color: typing.Optional[typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]]] = None, request_options: typing.Optional[RequestOptions] = None) -> AsyncHttpResponse[None]:
        """
        Parameters
        ----------
        operand : typing.Union[Operand, typing.Sequence[Operand]]
        
        operand_or_color : typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]]
        
        maybe_operand : typing.Optional[typing.Union[Operand, typing.Sequence[Operand]]]
        
        maybe_operand_or_color : typing.Optional[typing.Union[ColorOrOperand, typing.Sequence[ColorOrOperand]]]
        
        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.
        
        Returns
        -------
        AsyncHttpResponse[None]
        """
        _response = await self._client_wrapper.httpx_client.request(
            "query-list",method="POST",
            params={"operand": operand, "maybeOperand": maybe_operand, "operandOrColor": operand_or_color, "maybeOperandOrColor": maybe_operand_or_color, }
            ,
            request_options=request_options,)
        try:
            if 200 <= _response.status_code < 300:
                return AsyncHttpResponse(response=_response, data=None)
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response.text)
        raise ApiError(status_code=_response.status_code, headers=dict(_response.headers), body=_response_json)

/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mycompany.warehouse.openapi.api;

import com.mycompany.warehouse.openapi.model.BadRequest400Response;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.openapi.model.Error500Response;
import com.mycompany.warehouse.openapi.model.NotFound404Response;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")
@Validated
@Api(value = "boxes", description = "the boxes API")
public interface BoxesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /boxes : Create new box
     *
     * @param boxDto BoxDto (required)
     * @return OK (status code 201)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Create new box", nickname = "createBox", notes = "", response = BoxDto.class, tags={ "Boxes API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "OK", response = BoxDto.class),
        @ApiResponse(code = 400, message = "Bad Request", response = BadRequest400Response.class),
        @ApiResponse(code = 404, message = "Not Found", response = NotFound404Response.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error500Response.class) })
    @PostMapping(
        value = "/boxes",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<BoxDto> _createBox(@ApiParam(value = "BoxDto" ,required=true )  @Valid @RequestBody BoxDto boxDto) {
        return createBox(boxDto);
    }

    // Override this method
    default  ResponseEntity<BoxDto> createBox(BoxDto boxDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"locationCode\" : \"Shelf1\", \"boxId\" : 1, \"boxCode\" : \"Box 1\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
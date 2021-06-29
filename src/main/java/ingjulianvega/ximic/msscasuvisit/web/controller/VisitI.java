package ingjulianvega.ximic.msscasuvisit.web.controller;

import ingjulianvega.ximic.msscasuvisit.web.model.ApiError;
import ingjulianvega.ximic.msscasuvisit.web.model.Visit;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

public interface VisitI {

    @Operation(summary = "Endpoint to get the list of visits", description = "Returns a list of visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitList> get();

    @Operation(summary = "Endpoint to get the information of a visit given the id", description = "Returns a visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitDto> getById(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);


    @Operation(summary = "Endpoint to get the information of a visit given the patient id", description = "Returns a list of visits", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "patient-id/{patient-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitList> getByPatientId(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("patient-id") UUID patientId);

    @Operation(summary = "Endpoint to get the information of visits given a disease", description = "Returns a list of visits", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "disease/{disease-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitList> getByDiseaseId(@Parameter(in = ParameterIn.PATH, description = "The disease id", required = true, schema = @Schema()) @NotNull @PathVariable("disease-id") UUID diseaseId);


    @Operation(summary = "Endpoint to get the information of a visit given the creation date", description = "Returns a list of visits", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "created-date/{created-date}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitList> getByCreatedDate(@Parameter(in = ParameterIn.PATH, description = "The date of creation",
                                                required = true, schema = @Schema()) @NotNull @PathVariable("created-date")
                                               @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) OffsetDateTime createdDate);

    @Operation(summary = "Endpoint to create a visit", description = "Creates a new visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "visit's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Visit visit);

    @Operation(summary = "Endpoint to update the information of a visit given the id", description = "Updates a visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "visit's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Visit visit);


    @Operation(summary = "Endpoint to delete a visit", description = "Deletes a visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}

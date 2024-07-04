package com.admin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.admin.entity.VendorEmailEntity;
import com.admin.entity.VendorEntity;
import com.admin.request.VendorEmailRequest;
import com.admin.request.VendorRequest;
import com.admin.response.VendorDetailsResponse;
import com.admin.response.VendorEmailResponse;

/**
 * Mapper interface for converting between Vendor entities and DTOs.
 * 
 * <p>This interface uses MapStruct for mapping between {@link VendorEntity},
 * {@link VendorEmailEntity}, {@link VendorRequest}, {@link VendorEmailRequest},
 * {@link VendorDetailsResponse}, and {@link VendorEmailResponse}.</p>
 */
@Mapper(componentModel = "spring")
public interface VendorMapper {

    /**
     * Maps a {@link VendorRequest} to a {@link VendorEntity}.
     *
     * @param vendorRequest the vendor request DTO
     * @return the mapped vendor entity
     */
    VendorEntity mapFrom(VendorRequest vendorRequest);

    /**
     * Maps a {@link VendorEntity} to a {@link VendorDetailsResponse}.
     *
     * @param vendorEntity the vendor entity
     * @return the mapped vendor details response DTO
     */
    VendorDetailsResponse mapResponse(VendorEntity vendorEntity);

    /**
     * Maps a {@link VendorEmailEntity} to a {@link VendorEmailResponse}.
     *
     * @param vendorEmailEntity the vendor email entity
     * @return the mapped vendor email response DTO
     */
    @Mapping(target = "recipient", expression = "java(mapResponse(vendorEmailEntity.getRecipient()))")
    VendorEmailResponse mapEmailResponse(VendorEmailEntity vendorEmailEntity);

    /**
     * Maps a {@link VendorEmailRequest} to a {@link VendorEmailEntity}.
     *
     * @param emailRequest the vendor email request DTO
     * @return the mapped vendor email entity
     */
    @Mapping(target = "content", source = "body")
    VendorEmailEntity mapSentEmail(VendorEmailRequest emailRequest);

}
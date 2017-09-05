/**
 * AssetsPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public interface AssetsPortType extends java.rmi.Remote {

    /**
     * Adds a reservation to one or more folders.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType addReservation(com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Adds one or more restrictions to an Avid asset.
     * 
     *         Since: 1.4
     *         Modified: 2.3
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType addRestrictions(com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Adds one or more file mobs to an Avid asset.
     * 
     *         Since: 3.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType addFileMobs(com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Checkin a AMA AAF into IP.
     * 
     *         Since: 3.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType checkInAMAAAF(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Adds or updates a non-Avid asset in the Interplay system.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType checkIn(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Adds or updates an Avid AAF asset in the Interplay system.
     * 
     *         Since: 1.0
     *         Modified: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType checkInAAF(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Creates a new folder in the Interplay system.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType createFolder(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Creates new folders in the Interplay system.
     * 
     *         Since: 1.3
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType createFolders(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Create an empty masterclip to be captured later.
     * 
     *         Since: 2.0
     *         Modified: 2.5
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType createMasterClip(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Create a simple cuts-only shotlist.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType createShotlist(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Creates a subclip from a masterclip already in Interplay.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType createSubclip(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Deletes one or more assets and/or the media that matches them.
     * 
     *         Since: 1.2
     *         Modified: 2.3
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType deleteAssets(com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Creates a duplicate of an asset.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType duplicate(com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Finds all links to a specified asset.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType findLinks(com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Finds all relatives for a specified Avid asset.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType findRelatives(com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets a set of attributes for a list of assets.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType getAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets a set of attributes for a list of assets.
     * 
     *         Since: 2.6
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType getAttributesInternal(com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets a set of segments for a list of assets.
     * 
     *         Since: 2.5
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType getSegmentsFromComposition(com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the configured categories for the system and/or gets the
     * categories for a list
     *         of assets.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType getCategories(com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the child nodes of the passed in location. Optionally
     * includes or excludes files,
     *         folders, or MOBs. An optional name filter (* wildcards are
     * allowed) can restrict the
     *         return set to matching nodes.
     * 
     *         Since: 1.0
     *         Modified: 2.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType getChildren(com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Retrieve the list of custom attributes for the workgroup.
     * 
     *         Since: JXDK2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType getCustomUserAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Get the source file locations and statuses for one or more
     * assets.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType getFileDetails(com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the headframe of an asset in the Interplay system.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType getHeadframe(com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the latest version of an asset in the Interplay system.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType getLatest(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the locators for a given Avid asset.
     * 
     *         WARNING: This operation will be deprecated in a future version
     * of Interplay. Although it will continue
     *         to work withInterplay 1.x and 2.x systems, integrators are
     * advised to use the new UMID Locator
     *         operations and types instead.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType getLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the UMID-based locators for a given Avid asset.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType getUMIDLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the metasync XML that is embedded in a sequence.
     * 
     *         Since: 1.5
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType getMetaSyncXML(com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the reservations for one or more folders and/or assets
     * in the Interplay system.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType getReservations(com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the resolutions for Avid assets. For use in conjuction
     * with DeleteAssets.
     * 
     *         Since: 1.2
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType getResolutions(com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Gets the restrictions for one or more Avid assets.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType getRestrictions(com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Get the streaming proxy URL for clips/sequences that have been
     * WAN published.
     * 
     *         Since 2.0
     *         Modified: 2.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType getStreamingURL(com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Creates a new link (or reference) to a MOB in a specified location.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType linkToMOB(com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Modifies the permissions on a folder in Interplay (by user
     * or user group).
     * 
     *         Since: 1.2
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType modifyFolderACLs(com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Moves an asset to a different folder.
     * 
     *         Since: 1.0
     *         Modified: 2.3
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType move(com.spectralogic.escapepod.avidpamclient.soap.ws.MoveType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Renames an asset.
     * 
     *         Since: 2.2
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType rename(com.spectralogic.escapepod.avidpamclient.soap.ws.RenameType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Removes locators from an Avid asset.
     * 
     *         WARNING: This operation will be deprecated in a future version
     * of Interplay. Although it will continue
     *         to work withInterplay 1.x and 2.x systems, integrators are
     * advised to use the new UMID Locator
     *         operations and types instead.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType removeLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Removes UMID locators from an Avid asset.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType removeUMIDLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveUMIDLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Removes reservations from one or more folders.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType removeReservations(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Saves a locator. If a locator ID is passed in, and it references
     * an existing locator,
     *         it will update that locator. If no locator ID is passed in,
     * it will add a new locator.
     * 
     *         WARNING: This operation will be deprecated in a future version
     * of Interplay. Although it will continue
     *         to work withInterplay 1.x and 2.x systems, integrators are
     * advised to use the new UMID Locator
     *         operations and types instead.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType saveLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Saves a UMID locator. If a locator URI is passed in, and it
     * references an existing locator,
     *         it will update that locator. If no locator URI is passed in,
     * it will add a new UMID locator.
     * 
     *         Since: 1.1
     *         Modified: 2.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType saveUMIDLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Search for assets.
     * 
     *         Since: 1.0
     *         Modified: 2.2
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType search(com.spectralogic.escapepod.avidpamclient.soap.ws.SearchType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Sets custom attributes on a list of assets.
     * 
     *         Since: 1.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Adds and/or removes categories from an asset.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType setCategories(com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;

    /**
     * Sets a headframe for an Avid asset.
     * 
     *         Since: 1.1
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType setHeadframe(com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType;
}

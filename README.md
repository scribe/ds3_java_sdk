# escape_pod

## Goals
The primary goal of Escape Pod is to help customers migrate away from their existing Diva, Flashnet, and Masstech archive solutions.  There are some secondary goals, which are to privide as much feature parity as possible with a customer's existing archive solution so that the transition is transparent.

The most important non-funtional goal for Escape Pod is to be transparent to end users.  By transparent, we mean that a customer should be able to drop Escape Pod into an existing installation, and, with minimal transitional effort, be back up and running.  The perfect use case that describes this is that we should be able to replace a customer's current Avid PAM Archive Plugin with ours, and the only down time required to transition them is the time it takes to offline and re-online archive providers (we will explain this specific scenerio more later).

## Assumptions
* Users want a replacement for Diva, Flashnet, or Masstech.
* Post replacement, customers want a solution that is easy to use, gives them as much information about their storage system as possible, and the replacement (Escape Pod) doesn't complicate their workflow any more than it already is.
* The BlackPearl API is ill-suited for the M&E space due to it's complexity.  A more streamlined, completly asynchronous, solution will better fit the needs of M&E customers.

## Definitions
* File - A file that contains unspecified content.
* Media File - A file that contains video content.
* Asset - A media file which has a display name, and associated Media Files.
  * An example Asset from Avid PAM
    * Display name: WG2_AMS3_DNx145_Vadym.10.new.02
    * Mod ID: 060a2b340101010101010f0013-000000-59a846bec7d10926-060e2b347f7f-2a80
    * Files:
      * Name: wg2_ams3_da02.59a8459a846be.mxf
        * Path: \\SL-ISIS-55\media\Avid MediaFiles\MXF\ENG-DELL-35.1\Creating\1507065030097.1\wg2_ams3_da02.59a8459a846be.mxf
        * ID: 060a2b340101010101010f0013-000000-59a846bec7d10926-060e2b347f7f-2a80
      * Name: wg2_ams3_da01.59a8459a846be.mxf
        * Path:\\SL-ISIS-55\media\Avid MediaFiles\MXF\ENG-DELL-35.1\Creating\1507065030097.1\wg2_ams3_da01.59a8459a846be.mxf
        * ID: 060a2b340101010101010f0013-000000-59a846bec7d10926-060e2b347f7f-2a80
* Mob ID - A unique Asset and File identifier in Avid PAM

## Use Cases
1. Customer has Diva with Avid PAM
1. Customer has Flashnet with Avid PAM
1. Customer has Diva with Avid MAM
1. Customer has Flashnet with Avid MAM
1. Customers need a way to deliver content via FTP/SMB
1. Customers want insight into asset location on tape(s)
1. Partners developing their own integrations with Black Pearl
1. Partners developing their own integration with Black Pearl using Partial File Recovery for Assets
1. Customer has Grass Valley

## API Design
The primary interface for moving data will be via the Escape Pod's API.  As such, the file transferring interface is the most important part of the API.  Without an easy way to support the above use cases, Escape Pod will not be successful, and will not provide the kind of usability that our customers and partners need.

### File Transferring
File Transferring should be asynchronous and should hide all details of the BlackPearl API.  At no point should we expose Blobs or Chunks to users of this API.  Being asynchronous means that we'll need to be able to simultaneously read content that is stored in SMB shares (using UNC paths), Avid's Isis/Nexus storage system, and via FTP.

Most M&E workflows deal with assets as opposed to files directly.  Though most customers deal only with Assets managed either by Avid PAM or Avid MAM, we do have customers who deal only with files directly (if stored directly, they could use the browser, but for automation purposes we should incorperate the ability for users to archive individual files, as well as assets).

#### Examples:

Archive - POST to /api/jobs/archive
```json
{
  "files": [
    {
      "name": "fileName",
      "uri": "ftp://path"
    },
    {
      "name": "fileName",
      "uri": "smb://path"
    },
    {
      "name": "filename",
      "uri": "\\Share\foo\bar"
    }
  ],
  "assets": [
    {
      "name": "displayName",
      "files": [
        {
          "name": "filename",
          "uri": "\\Share\foo\bar\file.mxf"
        }
      ]
    }
  ]
}
```

Restore - POST to /api/jobs/restore
```json
{
  "assets": [
    {
      "name": "asset name",
      "destinationUri": "\\Share\foo\bar"
    },
    {
      "name": "asset name",
      "destinationUri": "\\Share\foo\bar",
      "timecodeRange": {
        "start": 123,
        "stop": 1253
      }
    }
  ],
  "files": [
    {
      "name": "file name",
      "destination": "\\Share\file\dest"
    },
    {
      "name": "partial file",
      "destination": "\\Share\partial\dest",
      "byteRange": {
        "start": 23,
        "stop": 2523
      }
    }
  ]
}
```

## Questions
* How to support both timecode and byte range Partial File Restores.  Specifically, how does it change when dealing with assets vs raw files.
* How to restore a specific file inside of an asset?  Is this needed?  If so, how does this work.
* Do we even need to make a distinction between files and assets?  Or should be use labels, or some other means of linking individual files together into an asset for external searching?
* Do we need to support multiple range Partial File Restores?  Does Marquis even support this?

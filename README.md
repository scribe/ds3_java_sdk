# escape_pod

## Goals
The primary goal of Escape Pod is to help customer's migrated away from their existing Diva, Flashnet, and Masstech archive solutions.  There are some secondary goals, which is to privide as much feature parity with a customer's existing archive solution so that the transition is transparent.

The most important non-funtional goals for Escape Pod is to be transparent to end users.  By transparent, we mean that a customer should be able to drop Escape Pod into an existing customer's install, and with minimal transition effort, they should be back up and running.  Perfect use case that describes this, is we should be able to replace a customer's current Avid PAM Archive Plugin with ours and the only down time required to transition them is the time it takes to offline and re-online archive providers (this specific scenerio will be explain more later).

## Assumptions
* Users want a replacement for Diva, Flashnet, or Masstech.
* Post replacement, the customer wants a solution that is easy to use, gives them as much information about their storage system as possible, and the replacement (Escape Pod) doesn't complicate their workflow anymore than it already is
* The BP API is ill suited for the M&E space due to it's complixity.  A more streamlined, completly asynchronous, solution will better fit the needs of M&E customers.

## Use Cases
1. Customer has Diva with Avid PAM
1. Customer has Flashnet with Avid PAM
1. Customer has Diva with Avid MAM
1. Customer has Flashnet with Avid MAM
1. Customer's need a way to deliver content via FTP/SMB
1. Customer's want insight into which assets are on which Tapes
1. Partners developing their own integrations with Black Pearl
1. Partners developing their own integration with Black Pearl using Partial File Recovery for Media Assets

## API Design
The primary interface for moving data will be via the Escape Pod's API.  As such the file transferring interface is the most important part of the API.  Without an easy way to suppor the above use cases, Escape Pod will not be successful, and will not provide the kind of usability that our customer's and partners need.

### File Transferring
File Transferring should be Asynchronous and should hide all details of the BP API.  At no point should we expose Blobs or Chunks to users of this API.  Being Asynchronous means that we'll need to be able to read content that is stored in SMB shares (using UNC paths), Avid's Isis/Nexus storage system, and via FTP.

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
    }
  ]
}
```

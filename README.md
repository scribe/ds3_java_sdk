# escape_pod

## Goals
The primary goal of Escape Pod is to help customer's migrated away from their existing Diva, Flashnet, and Masstech archive solutions.  There are some secondary goals, which is to privide as much feature parity with a customer's existing archive solution so that the transition is transparent.

The most important non-funtional goals for Escape Pod is to be transparent to end users.  By transparent, we mean that a customer should be able to drop Escape Pod into an existing customer's install, and with minimal transition effort, they should be back up and running.  Perfect use case that describes this, is we should be able to replace a customer's current Avid PAM Archive Plugin with ours and the only down time required to transition them is the time it takes to offline and re-online archive providers (this specific scenerio will be explain more later).

## Assumptions
* Users want a replacement for Diva, Flashnet, or Masstech.
* Post replacement, the customer wants a solution that is easy to use, gives them as much information about their storage system as possible, and the replacement (Escape Pod) doesn't complicate their workflow anymore than it already is
* The BP API is ill suited for the M&E space due to it's complixity.  A more streamlined, completly asynchronous, solution will better fit the needs of M&E customers.

## Use Cases
* Customer has Diva with Avid PAM
* Customer has Flashnet with Avid PAM
* Customer has Diva with Avid MAM
* Customer has Flashnet with Avid MAM
* Customer's need a way to deliver content via FTP/SMB
* Customer's want insight into which assets are on which Tapes

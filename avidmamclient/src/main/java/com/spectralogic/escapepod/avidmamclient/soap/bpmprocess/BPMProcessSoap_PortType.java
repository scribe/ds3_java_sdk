/**
 * BPMProcessSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidmamclient.soap.bpmprocess;

public interface BPMProcessSoap_PortType extends java.rmi.Remote {

    /**
     * Starts a process specified by className.<br/><u>Parameters:</u><br/><b><i>string</i>
     * accesskey</b>: A valid MAM session token.<br/><b><i>string</i> className</b>:
     * The process class name.<br/><b><i>List<MetaAttribute></i> metas</b>:
     * Process meta data attributes (optional).<br/><br/><b><i>List<MultiValueAttribute></i>
     * mvAttributes</b>: Multi-value (non-compound) or multi-value-compound
     * attributes (optional).<br/><br/><b><i>string</i> parentProcessId</b>:
     * Process ID of current running process. The process to be started is
     * stored as child process for parentProcessId. If empty, no relationship
     * to current process is stored. (optional)<br/><u>Exceptions:</u><br><b>InvalidParameterException</b>:
     * Parameters are invalid.<br><b>ArgumentNullException</b>: Parameters
     * are empty (e.g. empty).<br><b>InternalError</b>: If an unexpected
     * error occurred.<br/><br/>
     */
    public java.lang.String startProcess(java.lang.String accesskey, java.lang.String className, com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.MetaAttribute[] metas, com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.MultiValueAttribute[] mvAttributes, java.lang.String parentProcessId) throws java.rmi.RemoteException;

    /**
     * Returns process information (lifecycle, main title, GUID, error)
     * about requested process by processId.<br/>If the process object does
     * contain a DM attribute P_PROCESS_PARENT_ID the process status of current
     * process specified by <i>processId</i> is synchronized with its parent
     * process (only if P_CHILD_PROCESSES exists in parent process object).<br/><u>Parameters:</u><br/><b><i>string</i>
     * accesskey</b>: A valid MAM session token.<br/><b><i>string</i> processId</b>:
     * The DMGUID for process to request information for.<br/><u>Exceptions:</u><br><b>InvalidParameterException</b>:
     * Parameters are invalid.<br><b>ArgumentNullException</b>: Parameters
     * are empty (e.g. empty).<br><b>InternalError</b>: If an unexpected
     * error occurred.<br/><br/>
     */
    public com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.ProcessStatus getProcessStatus(java.lang.String accesskey, java.lang.String processId) throws java.rmi.RemoteException;

    /**
     * Returns process information (lifecycle, main title, GUID, error)
     * about requested process by processId.<br/><u>Parameters:</u><br/><b><i>string</i>
     * accesskey</b>: A valid MAM session token.<br/><b><i>string[]</i> processId</b>:
     * The DMGUIDs for processes to request information for.<br/><u>Exceptions:</u><br><b>InvalidParameterException</b>:
     * Parameters are invalid.<br><b>ArgumentNullException</b>: Parameters
     * are empty (e.g. empty).<br><b>InternalError</b>: If an unexpected
     * error occurred.<br/><br/>
     */
    public com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.ProcessStatus[] getProcessesStatus(java.lang.String accesskey, java.lang.String[] processIds) throws java.rmi.RemoteException;

    /**
     * Synchronizes child and parent process status.<br/><b>Note:
     * USe this method to get all child processes from the main process.
     * <br />For each child process the status is requested and updated in
     * its corresponding main process P_CHILD_PROCESSES MVC line.<br /> This
     * method should be used when the child process does not contain a DM
     * attribute named P_PROCESS_PARENT_ID. If the DM attribute is contained
     * in the data model use GetProcessStatus instead which automatically
     * syncs the status between the two objects.</b><br /><u>Parameters:</u><br/><b><i>string</i>
     * accesskey</b>: A valid MAM session token.<br/><b><i>string</i> processId</b>:
     * The DMGUID of the main process. All child processes are read from
     * main process P_CHILD_PROCESSES and their status (lifecycle, progress
     * etc.) are updated to their main process.<br/><u>Exceptions:</u><br><b>InvalidParameterException</b>:
     * Parameters are invalid.<br><b>ArgumentNullException</b>: Parameters
     * are empty (e.g. empty).<br><b>InternalError</b>: If an unexpected
     * error occurred.<br/><br/>
     */
    public void syncProcessStatus(java.lang.String accesskey, java.lang.String processId) throws java.rmi.RemoteException;

    /**
     * Increases the process progress (P_PROCESS_PROGRESS) of the
     * given process object by the given amount.<br/>The value of the process
     * progress is capped at 100.0.<br/>The access to this method is synchronized
     * on a process object level.<br/><br/><u>Parameters:</u><br/><b><i>string</i>
     * accesskey</b>: A valid MAM access token<br/><b><i>string</i> processGuid</b>:
     * The GUID of the process object.<br/><b><i>float</i> amountToIncrease</b>:
     * The amount the process progress will be increased.<br/><br/><u>Exceptions:</u><br><b>Client.WorkflowLibraryWS.InvalidParameter</b>:
     * Parameters are invalid (e.g. empty).<br><b>Server.WorkflowLibraryWS.InternalError</b>:
     * If an unexpected error occurred.<br/><br/><u>Workflow declaration</u>:
     * <i>declare void IncreaseProcessProgress(accesskey, processGuid, amountToIncrease);</i>
     */
    public void increaseProcessProgress(java.lang.String accesskey, java.lang.String processGuid, float amountToIncrease) throws java.rmi.RemoteException;
}

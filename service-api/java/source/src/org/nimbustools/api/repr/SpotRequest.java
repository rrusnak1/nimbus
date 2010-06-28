/*
 * Copyright 1999-2010 University of Chicago
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.nimbustools.api.repr;

import java.util.Calendar;

import org.nimbustools.api.repr.si.SIRequestState;
import org.nimbustools.api.repr.vm.ResourceAllocation;
import org.nimbustools.api.repr.vm.VMFile;


public interface SpotRequest {

    public String getRequestID();
    public Double getSpotPrice();
    public boolean isPersistent();    
    public SIRequestState getState();
    public Calendar getCreationTime();
    public String[] getVMIds();
    
    public VMFile[] getVMFiles();
    public String getSshKeyName();
    public Caller getCreator();
    public String getMdUserData();    
    public ResourceAllocation getResourceAllocation();
    public String getGroupID();
    
}
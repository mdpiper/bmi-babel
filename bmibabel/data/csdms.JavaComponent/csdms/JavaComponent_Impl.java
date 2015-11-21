/*
 * File:          JavaComponent_Impl.java
 * Symbol:        csdms.JavaComponent-v0.0
 * Symbol Type:   class
 * Babel Version: 1.4.0 (Revision: 6607 release-1-4-0-branch)
 * Description:   Server-side implementation for csdms.JavaComponent
 * 
 * WARNING: Automatically generated; only changes within splicers preserved
 * 
 */

package csdms;

import csdms.core.Bmi;
import gov.cca.CCAException;
import gov.cca.Component;
import gov.cca.ComponentRelease;
import gov.cca.Services;
import sidl.BaseClass;
import sidl.BaseInterface;
import sidl.ClassInfo;
import sidl.RuntimeException;

// DO-NOT-DELETE splicer.begin(csdms.JavaComponent._imports)
// Insert-Code-Here {csdms.JavaComponent._imports} (additional imports)
// DO-NOT-DELETE splicer.end(csdms.JavaComponent._imports)

/**
 * Symbol "csdms.JavaComponent" (version 0.0)
 */
public class JavaComponent_Impl extends JavaComponent
{

  // DO-NOT-DELETE splicer.begin(csdms.JavaComponent._data)

    // Bocca generated code. bocca.protected.begin(csdms.JavaComponent._data)
    gov.cca.Services    d_services;
    public boolean bocca_print_errs = true;
    // Bocca generated code. bocca.protected.end(csdms.JavaComponent._data)
  // DO-NOT-DELETE splicer.end(csdms.JavaComponent._data)


  static { 
  // DO-NOT-DELETE splicer.begin(csdms.JavaComponent._load)
  // Insert-Code-Here {csdms.JavaComponent._load} (class initialization)
  // DO-NOT-DELETE splicer.end(csdms.JavaComponent._load)

  }

  /**
   * User defined constructor
   */
  public JavaComponent_Impl(long IORpointer){
    super(IORpointer);
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.JavaComponent)
    // Insert-Code-Here {csdms.JavaComponent.JavaComponent} (constructor)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.JavaComponent)

  }

  /**
   * Back door constructor
   */
  public JavaComponent_Impl(){
    d_ior = _wrap(this);
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent._wrap)
    // Insert-Code-Here {csdms.JavaComponent._wrap} (_wrap)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent._wrap)

  }

  /**
   * User defined destructing method
   */
  public void dtor() throws Throwable{
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent._dtor)
    // Insert-Code-Here {csdms.JavaComponent._dtor} (destructor)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent._dtor)

  }

  /**
   * finalize method (Only use this if you're sure you need it!)
   */
  public void finalize() throws Throwable{
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.finalize)
    // Insert-Code-Here {csdms.JavaComponent.finalize} (finalize)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.finalize)

  }

  // user defined static methods: (none)

  // user defined non-static methods:
  /**
   * Method:  boccaSetServices[]
   */
  public void boccaSetServices_Impl (
    /*in*/ gov.cca.Services services ) 
    throws gov.cca.CCAException.Wrapper, 
    sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.boccaSetServices)
// DO-NOT-EDIT-BOCCA
// Bocca generated code. bocca.protected.begin(csdms.JavaComponent.boccaSetServices)

   this.d_services = services;

   gov.cca.ComponentRelease cr = (gov.cca.ComponentRelease)this; // CAST
   this.d_services.registerForRelease(cr);
   return;
// Bocca generated code. bocca.protected.end(csdms.JavaComponent.boccaSetServices)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.boccaSetServices)

  }

  /**
   * Method:  boccaReleaseServices[]
   */
  public void boccaReleaseServices_Impl (
    /*in*/ gov.cca.Services services ) 
    throws gov.cca.CCAException.Wrapper, 
    sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.boccaReleaseServices)
  // Bocca generated code. bocca.protected.begin(csdms.JavaComponent.boccaReleaseServices)

   this.d_services=null;

   return;
  // Bocca generated code. bocca.protected.end(csdms.JavaComponent.boccaReleaseServices)
    
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.boccaReleaseServices)

  }

  /**
   *  This function should never be called, but helps babel generate better code. 
   */
  public void boccaForceUsePortInclude_Impl () 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.boccaForceUsePortInclude)
  // DO-NOT-EDIT-BOCCA
  // Bocca generated code. bocca.protected.begin(csdms.JavaComponent.boccaForceUsePortInclude)

  // Bocca generated code. bocca.protected.end(csdms.JavaComponent.boccaForceUsePortInclude)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.boccaForceUsePortInclude)

  }

  /**
   *  Starts up a component presence in the calling framework.
   * @param services the component instance's handle on the framework world.
   * Contracts concerning services and setServices:
   * 
   * The component interaction with the CCA framework
   * and Ports begins on the call to setServices by the framework.
   * 
   * This function is called exactly once for each instance created
   * by the framework.
   * 
   * The argument services will never be nil/null.
   * 
   * Those uses ports which are automatically connected by the framework
   * (so-called service-ports) may be obtained via getPort during
   * setServices.
   */
  public void setServices_Impl (
    /*in*/ gov.cca.Services services ) 
    throws gov.cca.CCAException.Wrapper, 
    sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.setServices)

  // Insert-Code-Here {csdms.JavaComponent.setServices} (setServices method prolog)

  // bocca-default-code. User may edit or delete.begin(csdms.JavaComponent.setServices)
     boccaSetServices(services); 
  // bocca-default-code. User may edit or delete.end(csdms.JavaComponent.setServices)

  // Insert-Code-Here {csdms.JavaComponent.setServices} (setServices method epilog)

    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.setServices)

  }

  /**
   * Shuts down a component presence in the calling framework.
   * @param services the component instance's handle on the framework world.
   * Contracts concerning services and setServices:
   * 
   * This function is called exactly once for each callback registered
   * through Services.
   * 
   * The argument services will never be nil/null.
   * The argument services will always be the same as that received in
   * setServices.
   * 
   * During this call the component should release any interfaces
   * acquired by getPort().
   * 
   * During this call the component should reset to nil any stored
   * reference to services.
   * 
   * After this call, the component instance will be removed from the
   * framework. If the component instance was created by the
   * framework, it will be destroyed, not recycled, The behavior of
   * any port references obtained from this component instance and
   * stored elsewhere becomes undefined.
   * 
   * Notes for the component implementor:
   * 1) The component writer may perform blocking activities
   * within releaseServices, such as waiting for remote computations
   * to shutdown.
   * 2) It is good practice during releaseServices for the component
   * writer to remove or unregister all the ports it defined.
   */
  public void releaseServices_Impl (
    /*in*/ gov.cca.Services services ) 
    throws gov.cca.CCAException.Wrapper, 
    sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.releaseServices)

  // Insert-Code-Here {csdms.JavaComponent.releaseServices} (releaseServices method prolog)

  // bocca-default-code. User may edit or delete.end(csdms.JavaComponent.releaseServices)
     boccaReleaseServices(services); 
  // bocca-default-code. User may edit or delete.end(csdms.JavaComponent.releaseServices)

  // Insert-Code-Here {csdms.JavaComponent.releaseServices} (releaseServices method epilog)

    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.releaseServices)

  }

  /**
   * Method:  initialize[]
   */
  public boolean initialize_Impl (
    /*in*/ java.lang.String config_file ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.initialize)
    // Insert-Code-Here {csdms.JavaComponent.initialize} (initialize)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.initialize)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.initialize)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.initialize)

  }

  /**
   * Method:  update[]
   */
  public boolean update_Impl () 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.update)
    // Insert-Code-Here {csdms.JavaComponent.update} (update)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.update)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.update)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.update)

  }

  /**
   * Method:  update_until[]
   */
  public boolean update_until_Impl (
    /*in*/ double time_interval ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.update_until)
    // Insert-Code-Here {csdms.JavaComponent.update_until} (update_until)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.update_until)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.update_until)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.update_until)

  }

  /**
   * Method:  finish[]
   */
  public boolean finish_Impl () 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.finish)
    // Insert-Code-Here {csdms.JavaComponent.finish} (finish)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.finish)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.finish)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.finish)

  }

  /**
   * Method:  get_start_time[]
   */
  public int get_start_time_Impl (
    /*out*/ sidl.Double.Holder time ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_start_time)
    // Insert-Code-Here {csdms.JavaComponent.get_start_time} (get_start_time)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_start_time)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_start_time)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_start_time)

  }

  /**
   * Method:  get_current_time[]
   */
  public int get_current_time_Impl (
    /*out*/ sidl.Double.Holder time ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_current_time)
    // Insert-Code-Here {csdms.JavaComponent.get_current_time} (get_current_time)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_current_time)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_current_time)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_current_time)

  }

  /**
   * Method:  get_end_time[]
   */
  public int get_end_time_Impl (
    /*out*/ sidl.Double.Holder time ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_end_time)
    // Insert-Code-Here {csdms.JavaComponent.get_end_time} (get_end_time)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_end_time)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_end_time)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_end_time)

  }

  /**
   * Method:  get_time_step[]
   */
  public int get_time_step_Impl (
    /*out*/ sidl.Double.Holder time ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_time_step)
    // Insert-Code-Here {csdms.JavaComponent.get_time_step} (get_time_step)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_time_step)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_time_step)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_time_step)

  }

  /**
   * Method:  get_time_units[]
   */
  public int get_time_units_Impl (
    /*out*/ sidl.String.Holder units ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_time_units)
    // Insert-Code-Here {csdms.JavaComponent.get_time_units} (get_time_units)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_time_units)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_time_units)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_time_units)

  }

  /**
   * Method:  get_component_name[]
   */
  public int get_component_name_Impl (
    /*out*/ sidl.String.Holder name ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_component_name)
    // Insert-Code-Here {csdms.JavaComponent.get_component_name} (get_component_name)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_component_name)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_component_name)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_component_name)

  }

  /**
   * Method:  get_input_item_count[]
   */
  public int get_input_item_count_Impl (
    /*out*/ sidl.Integer.Holder count ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_input_item_count)
    // Insert-Code-Here {csdms.JavaComponent.get_input_item_count} (get_input_item_count)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_input_item_count)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_input_item_count)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_input_item_count)

  }

  /**
   * Method:  get_output_item_count[]
   */
  public int get_output_item_count_Impl (
    /*out*/ sidl.Integer.Holder count ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_output_item_count)
    // Insert-Code-Here {csdms.JavaComponent.get_output_item_count} (get_output_item_count)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_output_item_count)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_output_item_count)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_output_item_count)

  }

  /**
   * Method:  get_input_var_names[]
   */
  public int get_input_var_names_Impl (
    /*out*/ sidl.String.Array1.Holder names ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_input_var_names)
    // Insert-Code-Here {csdms.JavaComponent.get_input_var_names} (get_input_var_names)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_input_var_names)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_input_var_names)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_input_var_names)

  }

  /**
   * Method:  get_output_var_names[]
   */
  public int get_output_var_names_Impl (
    /*out*/ sidl.String.Array1.Holder names ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_output_var_names)
    // Insert-Code-Here {csdms.JavaComponent.get_output_var_names} (get_output_var_names)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_output_var_names)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_output_var_names)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_output_var_names)

  }

  /**
   * Method:  get_var_type[]
   */
  public int get_var_type_Impl (
    /*in*/ java.lang.String name,
    /*out*/ sidl.String.Holder type ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_var_type)
    // Insert-Code-Here {csdms.JavaComponent.get_var_type} (get_var_type)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_var_type)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_var_type)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_var_type)

  }

  /**
   * Method:  get_var_units[]
   */
  public int get_var_units_Impl (
    /*in*/ java.lang.String name,
    /*out*/ sidl.String.Holder units ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_var_units)
    // Insert-Code-Here {csdms.JavaComponent.get_var_units} (get_var_units)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_var_units)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_var_units)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_var_units)

  }

  /**
   * Method:  get_var_nbytes[]
   */
  public int get_var_nbytes_Impl (
    /*in*/ java.lang.String name,
    /*out*/ sidl.Integer.Holder nbytes ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_var_nbytes)
    // Insert-Code-Here {csdms.JavaComponent.get_var_nbytes} (get_var_nbytes)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_var_nbytes)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_var_nbytes)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_var_nbytes)

  }

  /**
   * Method:  get_var_itemsize[]
   */
  public int get_var_itemsize_Impl (
    /*in*/ java.lang.String name,
    /*out*/ sidl.Integer.Holder size ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_var_itemsize)
    // Insert-Code-Here {csdms.JavaComponent.get_var_itemsize} (get_var_itemsize)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_var_itemsize)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_var_itemsize)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_var_itemsize)

  }

  /**
   * Method:  get_var_grid[]
   */
  public int get_var_grid_Impl (
    /*in*/ java.lang.String name,
    /*out*/ sidl.Integer.Holder grid ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_var_grid)
    // Insert-Code-Here {csdms.JavaComponent.get_var_grid} (get_var_grid)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_var_grid)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_var_grid)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_var_grid)

  }

  /**
   * Method:  get_grid_type[]
   */
  public int get_grid_type_Impl (
    /*in*/ int grid,
    /*out*/ sidl.String.Holder type ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_type)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_type} (get_grid_type)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_type)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_type)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_type)

  }

  /**
   * Method:  get_grid_rank[]
   */
  public int get_grid_rank_Impl (
    /*in*/ int grid,
    /*out*/ sidl.Integer.Holder rank ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_rank)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_rank} (get_grid_rank)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_rank)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_rank)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_rank)

  }

  /**
   * Method:  get_grid_size[]
   */
  public int get_grid_size_Impl (
    /*in*/ int grid,
    /*out*/ sidl.Integer.Holder size ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_size)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_size} (get_grid_size)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_size)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_size)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_size)

  }

  /**
   * Method:  get_grid_shape[]
   */
  public int get_grid_shape_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Integer.Array1 shape ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_shape)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_shape} (get_grid_shape)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_shape)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_shape)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_shape)

  }

  /**
   * Method:  get_grid_spacing[]
   */
  public int get_grid_spacing_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Double.Array1 spacing ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_spacing)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_spacing} (get_grid_spacing)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_spacing)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_spacing)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_spacing)

  }

  /**
   * Method:  get_grid_origin[]
   */
  public int get_grid_origin_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Double.Array1 origin ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_origin)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_origin} (get_grid_origin)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_origin)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_origin)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_origin)

  }

  /**
   * Method:  get_grid_x[]
   */
  public int get_grid_x_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Double.Array1 x ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_x)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_x} (get_grid_x)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_x)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_x)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_x)

  }

  /**
   * Method:  get_grid_y[]
   */
  public int get_grid_y_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Double.Array1 y ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_y)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_y} (get_grid_y)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_y)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_y)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_y)

  }

  /**
   * Method:  get_grid_z[]
   */
  public int get_grid_z_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Double.Array1 z ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_z)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_z} (get_grid_z)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_z)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_z)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_z)

  }

  /**
   * Method:  get_grid_connectivity[]
   */
  public int get_grid_connectivity_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Integer.Array1 connectivity ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_connectivity)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_connectivity} (get_grid_connectivity)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_connectivity)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_connectivity)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_connectivity)

  }

  /**
   * Method:  get_grid_offset[]
   */
  public int get_grid_offset_Impl (
    /*in*/ int grid,
    /*in*/ sidl.Integer.Array1 offset ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_grid_offset)
    // Insert-Code-Here {csdms.JavaComponent.get_grid_offset} (get_grid_offset)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_grid_offset)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_grid_offset)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_grid_offset)

  }

  /**
   * Method:  get_value[]
   */
  public int get_value_Impl (
    /*in*/ java.lang.String name,
    /*in*/ gov.llnl.sidl.BaseArray dest ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_value)
    // Insert-Code-Here {csdms.JavaComponent.get_value} (get_value)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_value)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_value)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_value)

  }

  /**
   * Method:  get_value_ptr[]
   */
  public int get_value_ptr_Impl (
    /*in*/ java.lang.String name,
    /*out*/ gov.llnl.sidl.BaseArray.Holder values ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_value_ptr)
    // Insert-Code-Here {csdms.JavaComponent.get_value_ptr} (get_value_ptr)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_value_ptr)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_value_ptr)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_value_ptr)

  }

  /**
   * Method:  get_value_at_indices[]
   */
  public int get_value_at_indices_Impl (
    /*in*/ java.lang.String name,
    /*in*/ gov.llnl.sidl.BaseArray dest,
    /*in*/ sidl.Integer.Array1 inds ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.get_value_at_indices)
    // Insert-Code-Here {csdms.JavaComponent.get_value_at_indices} (get_value_at_indices)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.get_value_at_indices)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.get_value_at_indices)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.get_value_at_indices)

  }

  /**
   * Method:  set_value[]
   */
  public int set_value_Impl (
    /*in*/ java.lang.String name,
    /*in*/ gov.llnl.sidl.BaseArray values ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.set_value)
    // Insert-Code-Here {csdms.JavaComponent.set_value} (set_value)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.set_value)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.set_value)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.set_value)

  }

  /**
   * Method:  set_value_at_indices[]
   */
  public int set_value_at_indices_Impl (
    /*in*/ java.lang.String name,
    /*in*/ sidl.Integer.Array1 inds,
    /*in*/ gov.llnl.sidl.BaseArray src ) 
    throws sidl.RuntimeException.Wrapper
  {
    // DO-NOT-DELETE splicer.begin(csdms.JavaComponent.set_value_at_indices)
    // Insert-Code-Here {csdms.JavaComponent.set_value_at_indices} (set_value_at_indices)
    /*
     * This method has not been implemented
     */

    // DO-DELETE-WHEN-IMPLEMENTING exception.begin(csdms.JavaComponent.set_value_at_indices)
    sidl.NotImplementedException noImpl = new sidl.NotImplementedException();
    noImpl.setNote("This method has not been implmented.");
    sidl.RuntimeException.Wrapper rex = (sidl.RuntimeException.Wrapper) sidl.RuntimeException.Wrapper._cast(noImpl);
    throw rex;
    // DO-DELETE-WHEN-IMPLEMENTING exception.end(csdms.JavaComponent.set_value_at_indices)
    // DO-NOT-DELETE splicer.end(csdms.JavaComponent.set_value_at_indices)

  }


  // DO-NOT-DELETE splicer.begin(csdms.JavaComponent._misc)
  // Insert-Code-Here {csdms.JavaComponent._misc} (miscellaneous)
  // DO-NOT-DELETE splicer.end(csdms.JavaComponent._misc)

} // end class JavaComponent


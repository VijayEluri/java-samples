
package jaxor.sample;

import net.sourceforge.jaxor.*;
import net.sourceforge.jaxor.api.FieldAdapter;


public class EmpEntityRow extends net.sourceforge.jaxor.EntityRow{

   public final FieldAdapter ename;
   public final FieldAdapter job;
   public final FieldAdapter mgr;
   public final FieldAdapter hiredate;
   public final FieldAdapter sal;
   public final FieldAdapter comm;
   public final FieldAdapter deptno;
   public final FieldAdapter empno;



	public EmpEntityRow (){
	    this(new EmpMetaRow());
	}

	public EmpEntityRow (MetaRow meta){
		super(meta.getTableName());
		net.sourceforge.jaxor.util.EntityRowBuilder builder = new net.sourceforge.jaxor.util.EntityRowBuilder();
        ename = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("ename"), null);
		builder.add( ename );
        job = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("job"), null);
		builder.add( job );
        mgr = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("mgr"), null);
		builder.add( mgr );
        hiredate = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("hiredate"), null);
		builder.add( hiredate );
        sal = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("sal"), null);
		builder.add( sal );
        comm = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("comm"), null);
		builder.add( comm );
        deptno = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("deptno"), null);
		builder.add( deptno );
        empno = new net.sourceforge.jaxor.mappers.FieldAdapterImpl(meta.findMetaByColumn("empno"), null);
		builder.add( empno );
        setPrimaryKey(builder.getPrimaryKey());
        setFields(builder.getFields());

	}
}

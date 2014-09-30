/**
 * 
 */
package sample.jdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

/**
 * �t�B�[���h��JavaDoc�R�����g����Getter/Setter��JavaDoc���\�z���鐶���A�N�V����.
 * @author Takahiro Shida.
 * 
 */
public class GenerateGetterSetterWithJavaDoc implements IEditorActionDelegate {

	/**
	 * �ԈႢ�Ȃ�CompilationUnitEditor.
	 */
	IEditorPart editorPart;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		// �G�f�B�^����t�@�C�����擾���A�����ICompilationUnit�ɕϊ�����.
		IEditorInput editorInput = editorPart.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput) editorInput;
			IFile file = input.getFile();
			ICompilationUnit element = (ICompilationUnit) JavaCore.create(file);
			// ICompilationUnit���p�[�X����.
			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setResolveBindings(true);
			parser.setSource(element);
			CompilationUnit node = (CompilationUnit) parser
					.createAST(new NullProgressMonitor());
			//�\�[�X�̒�����t�B�[���h���E���A���\�b�h��������\�z����.
			FieldVisitor visitor = new FieldVisitor();
			node.accept(visitor);
			//���\�b�h��������t�@�C���ɒǉ����Ă���.
			List methods = visitor.getMethods();
			try {
				IType type = element.getTypes()[0];
				for (int i = 0; i < methods.size(); i++) {
					String method = (String) methods.get(i);
					try {
						type.createMethod(method, null, false,
								new NullProgressMonitor());
					} catch (JavaModelException e) {
						// ���łɓ������\�b�h����������ǉ����Ȃ�.
					}
				}
				//�ύX��ۑ�����.
				element.commitWorkingCopy(true, new NullProgressMonitor());
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ���ׂẴt�B�[���h��T��Visitor.
	 */
	class FieldVisitor extends ASTVisitor {

		private List accessor = new ArrayList();

		public boolean visit(FieldDeclaration node) {
			FieldDetailVisitor visitor = new FieldDetailVisitor();
			node.accept(visitor);
			accessor.add(visitor.getGetterString());
			accessor.add(visitor.getSetterString());
			return super.visit(node);
		}

		public List getMethods() {
			return accessor;
		}
	}

	/**
	 * �t�B�[���h����JavaDoc�^�O�ƌ^���A���O������Ă���Getter/Setter��������\�z.
	 *
	 */
	class FieldDetailVisitor extends ASTVisitor {

		private String javadoc = "";

		private String type = "";

		private String name = "";

		boolean bool;

		FieldDetailVisitor() {
			super(true);
		}

		public boolean visit(TextElement node) {
			javadoc = node.getText().replaceAll("\\.","");
			return super.visit(node);
		}

		public boolean visit(FieldDeclaration node) {
			Type t = node.getType();
			type = t.resolveBinding().getName();
			return super.visit(node);
		}

		public boolean visit(SimpleName node) {
			name = node.getFullyQualifiedName();
			return super.visit(node);
		}

		public boolean visit(TagElement node) {
			return super.visit(node);
		}

		/**
		 * Getter���\�b�h��������\�z���ĕԂ�.
		 * ������蕶����ɂ��Ă���.
		 * @return
		 */
		public String getGetterString() {
			String doc = "/**\n * " + javadoc + "���擾����.\n * @return " + javadoc + "\n */\n";
			String cased = name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			if ("boolean".equals(type)) {
				return doc + "public " + type + " is" + cased
						+ "() {\n\t return " + name + ";\n}";
			} else {
				return doc + "public " + type + " get" + cased
						+ "() {\n\t return " + name + ";\n}";
			}
		}

		/**
		 * Setter���\�b�h��������\�z���ĕԂ�.
		 * @return
		 */
		public String getSetterString() {
			String doc = "/**\n * " + javadoc + "��ݒ肷��.\n * @param " + name + " "
					+ javadoc + "\n */\n";
			String cased = name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			return doc + "public void set" + cased + "(" + type + " " + name
					+ ") {\n\t this." + name + " = " + name + ";\n}";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// �Ȃɂ����Ȃ�.
	}

	/*
	 *  (non-Javadoc)
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction, org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editorPart = targetEditor;
	}

}

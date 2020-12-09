package dsw.rudok.app.gui.swing.tree.model;


import dsw.rudok.app.gui.swing.tree.view.RuTreeImplementation;
import dsw.rudok.app.gui.swing.tree.view.RuTreeView;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.observer.IPublisher;
import dsw.rudok.app.observer.ISubscriber;
import dsw.rudok.app.repository.Document;
import dsw.rudok.app.repository.Page;
import dsw.rudok.app.repository.Project;
import dsw.rudok.app.repository.Workspace;
import dsw.rudok.app.repository.node.RuNode;
import dsw.rudok.app.repository.node.RuNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Flow;

public class RuTreeItem extends DefaultMutableTreeNode implements ISubscriber {

    private String name;
    private RuNode nodeModel;
    private RuTreeImplementation impl=new RuTreeImplementation();


    public RuTreeItem(RuNode nodeModel){
        this.nodeModel=nodeModel;
        this.name=nodeModel.getName();
        nodeModel.addSubs(this);
    }
    public RuTreeItem(RuNode ruNode,String name){
        this.name=name;
        this.nodeModel=ruNode;
        nodeModel.addSubs(this);
    }
    @Override
    public int getIndex(TreeNode node){
        return findIndexByChild((RuTreeItem)node);
    }
    @Override
    public TreeNode getChildAt(int childIndex){
        return findChildByIndex(childIndex);
    }
    @Override
    public int getChildCount(){
            if(nodeModel instanceof RuNodeComposite)
                return ((RuNodeComposite)nodeModel).getChildren().size();
            return 0;
        }
    @Override
    public boolean getAllowsChildren(){
        if(nodeModel instanceof RuNodeComposite)
            return true;
        return false;
    }
    @Override
    public boolean isLeaf(){
        if(nodeModel instanceof RuNodeComposite)
            return false;
        return true;
    }


    @Override
    public Enumeration children(){
        if(nodeModel instanceof RuNodeComposite)
            return (Enumeration)((RuNodeComposite)nodeModel).getChildren();
        return null;
    }
    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof RuTreeItem){
            RuTreeItem otherObj = (RuTreeItem)obj;
            return this.nodeModel.equals(otherObj.nodeModel);
        }
        return false;
    }
    private TreeNode findChildByIndex(int childIndex){
        if(nodeModel instanceof RuNodeComposite){
            RuTreeItem toLookFor = new RuTreeItem(((RuNodeComposite)nodeModel).getChildren().get(childIndex));
            Iterator childrenIterator = children.iterator();
            TreeNode current;

            while(childrenIterator.hasNext()){
                current = (TreeNode)childrenIterator.next();
                if(current.equals(toLookFor))
                    return current;
            }
        }
        return null;
    }
    private int findIndexByChild(RuTreeItem node){
        if(this.nodeModel instanceof RuNodeComposite){
            return ((RuNodeComposite)this.nodeModel).getChildren().indexOf(node.getNodeModel());
        }
        return -1;
    }
    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
            this.nodeModel.setName(name);
        }
    }

    public String getName() {
        return name;
    }

    public RuNode getNodeModel() {
        return nodeModel;
    }

    public void setNodeModel(RuNode nodeModel) {
        this.nodeModel = nodeModel;
    }

    @Override
    public void insert(MutableTreeNode newChild, int childIndex) {
        if (!allowsChildren) {
            throw new IllegalStateException("node does not allow children");
        } else if (newChild == null) {
            throw new IllegalArgumentException("new child is null");
        } else if (isNodeAncestor(newChild)) {
            throw new IllegalArgumentException("new child is an ancestor");
        }

      //  MutableTreeNode oldParent = (MutableTreeNode)newChild.getParent();
/*
        if (oldParent != null) {
            oldParent.remove(newChild);
        }
 */
        //newChild.setParent(this);
        if (children == null) {
            children = new Vector<>();
        }
        children.insertElementAt(newChild, childIndex);
    }

    @Override
    public void update(Object notif) {
        /*if(notif instanceof RuTreeItem){
            RuTreeItem item=(RuTreeItem)notif;
            this.insert(item,this.getChildCount());

            //this.add(item);

            *//*Project p=(Project) this.getNodeModel();
            Document d=(Document) item.getNodeModel();
            p.addChild(d);*//*
        }*/
    }
}

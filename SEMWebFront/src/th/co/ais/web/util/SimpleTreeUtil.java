/**
 * License Agreement.
 *
 *  JBoss RichFaces - Ajax4jsf Component Library
 *
 * Copyright (C) 2007  Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */

package th.co.ais.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.component.html.HtmlTreeNode;
import org.richfaces.component.state.TreeState;
import org.richfaces.event.NodeExpandedEvent;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;
import org.richfaces.model.TreeRowKey;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.BankMasterSP;
import th.co.ais.service.gm.IBankMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;

public class SimpleTreeUtil extends AbstractAction {
    
    private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    private static final String DATA_PATH = "/richfaces/tree/examples/simple-tree-data.properties";
    
    private void addNodes(String path, TreeNode node, Properties properties) {
        boolean end = false;
        int counter = 1;
        
        while (!end) {
            String key = path != null ? path + '.' + counter : String.valueOf(counter);

            String value = properties.getProperty(key);
            if (value != null) {
                TreeNodeImpl nodeImpl = new TreeNodeImpl();
                nodeImpl.setData(value);
                node.addChild(new Integer(counter), nodeImpl);
                addNodes(key, nodeImpl, properties);
                counter++;
            } else {
                end = true;
            }
        }
    }
    
    private void loadTree() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        InputStream dataStream = externalContext.getResourceAsStream(DATA_PATH);
        try {
            Properties properties = new Properties();
            properties.load(dataStream);
            
            rootNode = new TreeNodeImpl();
            addNodes(null, rootNode, properties);
            
        } catch (IOException e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
            if (dataStream != null) {
                try {
                    dataStream.close();
                } catch (IOException e) {
                    externalContext.log(e.getMessage(), e);
                }
            }
        }
    }
    
    public void processSelection(NodeSelectedEvent event) {
    	System.out.println(">>>> NodeSelectedEvent");
        HtmlTree tree = (HtmlTree) event.getComponent();
        //nodeTitle = (String) tree.getRowData();
        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
            System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
    }
    
    public TreeNode getTreeNode() {
        if (rootNode == null) {
            //loadTree_();
            loadTree_2();
        }
        
        return rootNode;
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
    
    public MenuTreeSP getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(MenuTreeSP nodeValue) {
        this.nodeValue = nodeValue;
    }
    
    
    
    //// >>
    public MenuTreeSP getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(MenuTreeSP menuRoot) {
        this.menuRoot = menuRoot;
    }
    //// <<
    
    
    
    /// test ...
    private void addNodes_(TreeNode node, List<SelectItem> properties) {
        boolean end = false;
        int counter = 1;
        	
        //TreeNode<String> rootNode = new TreeNodeImpl<String>();
        node.setData("xxxxxxx");
        
        	if (properties != null) {
        		for(int i=0; i<properties.size()-50; i++){
        			
        			TreeNode<String> subNode = new TreeNodeImpl<String>();
        			subNode.setData(properties.get(i).getValue().toString());
        			node.addChild(i, subNode);
        			
        			for(int j=0; j<properties.size()-75; j++) {
        				TreeNode<String> childNode = new TreeNodeImpl<String>();
        				childNode.setData(properties.get(i).getLabel());
        				subNode.addChild(j, childNode);
        			}
        			
	                /*TreeNodeImpl nodeImpl = new TreeNodeImpl();
	                nodeImpl.setData(properties.get(i).getLabel());
	                node.addChild(++i, nodeImpl);*/
	                
        		}
            }
    }
    
    private void loadTree_() {
        try {
        	
        	List<SelectItem> list = ProvinceCacheUtil.getInstance().getProvinceSelList();
        	rootNode = new TreeNodeImpl();
            addNodes_(rootNode, list);
        	
        
            
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
            
        }
    }
    
    
    
    /// test 2 ...
    private void addNodes_2(TreeNode node, List<Object> propList) {
    	
    	System.out.println("xxx propList size: " + propList.size());

    	for(int i=0; i<propList.size(); i++) {

    		// parent node (1. initial)
    		Map<String, Object> map = (Map<String, Object>) propList.get(i);
    		System.out.println("map i["+i+"]: " + map.keySet());
    		
    		int mapSize = map.keySet().size();
    		Object[] mapArr = map.keySet().toArray();
    		
    		for(int x=0; x<mapSize; x++){
    			////>>
    			String parentNode = mapArr[x].toString();
    			//System.out.println("parentNode ["+x+"]: " + parentNode + ": " + map.get(parentNode));

				TreeNode<MenuTreeSP> subNode = new TreeNodeImpl<MenuTreeSP>();	//TreeUtilBean

				// child node	
				MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
				System.out.println("childList MenuTreeSP: " + mapObj.getMenuLevel());
				System.out.println("childList MenuTreeSP: " + mapObj.getMenuLabel());
				System.out.println("childList MenuTreeSP: " + mapObj.getMenuUrl());

				
				for(int j=0; j<3; j++) {
		    		
		    		
					TreeNode<MenuTreeSP> childNode = new TreeNodeImpl<MenuTreeSP>();
					
					MenuTreeSP childData = new MenuTreeSP();
					childData.setMenuLevel(mapObj.getMenuLevel());
					childData.setMenuUrl(mapObj.getMenuUrl());
					
					childNode.setData(childData);
					subNode.addChild(j, childNode);
					
				}
				////<<
				
				////////>>
				/*TreeNode<MenuTreeSP> childNode = new TreeNodeImpl<MenuTreeSP>();
				MenuTreeSP childData = new MenuTreeSP();
				childData.setMenuLabel(mapObj.getMenuLabel());
				childData.setMenuUrl(mapObj.getMenuUrl());
				
				childNode.setData(childData);
				subNode.addChild(x, childNode);*/
				///////<<
				
				
				MenuTreeSP rootData = new MenuTreeSP();
				rootData.setMenuLabel(mapObj.getMenuLabel() + " (" + mapObj.getRecordCount() + ")");
				
				// parent node (2. assign)
				subNode.setData(rootData);	// subNode.setData(parentNode + " \n\n (" + countChild + ")");
				node.addChild(x, subNode);
    		}
    	}
    }
    
    private void loadTree_2() {
        try {

        	//// >>
        	TreeUtilBean myParam = new TreeUtilBean();
        	List<Object> mySendList = new ArrayList<Object>();
        	
        	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
        	
        	String groupType[] = {"N", "R", "O"};
        	
        	for(String mnGrp : groupType) {
        		myParam.setMenuGroup(mnGrp);
	        	myParam.setUserLogin(getUserLogIn());
	        	
	        	List<MenuTreeSP> menuTreeList = null;
	        	menuTreeList = service.querySPList(EQueryName.SP_MSA001_GET_TODO_MENU.name, myParam);

        		Map<String, Object> myMap = new HashMap<String, Object>();
	        	
	        	if(menuTreeList != null && !menuTreeList.isEmpty()){

	        		/// >
	        		for(int j=0; j<menuTreeList.size(); j++){
	        			String mLevel = menuTreeList.get(j).getMenuLevel();
        				myMap.put(mLevel, menuTreeList.get(j));
        				//System.out.println("---------- mLevel ["+ mLevel +"] >> " + myMap.get(mLevel));
	        		}
	        		mySendList.add(myMap);
	        		/// <
	        		
	        	}
        	}
        	rootNode = new TreeNodeImpl();
    		addNodes_final(rootNode, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
            
        }
    }

    
    
    
    
    
    
    
    
    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes_final(TreeNode masterRoot, List<Object> propList) {
    	
    	System.out.println("xxx propList size: " + propList.size());
    	
    	for(int i=0; i<propList.size(); i++) {

        	// >>
    		Map<String, Object> map = (Map<String, Object>) propList.get(i);
    		System.out.println("map i["+i+"]: " + map.keySet());
    		
    		int mapSize = map.keySet().size();
    		Object[] mapArr = map.keySet().toArray();
    		
MenuTreeSP myParent = new MenuTreeSP();
myParent.setMenuLabel("xxxxx node [" + i + "]");
    		
    		// >>
    		//TreeNodeImpl<String> stationNodes = new TreeNodeImpl<String>(); 
    		TreeNodeImpl<MenuTreeSP> stationNodes = new TreeNodeImpl<MenuTreeSP>();
    		
    		MenuTreeSP menuTreeObj = new MenuTreeSP();
    		
    		stationNodes.setData(myParent);
    		stationNodes.setParent(stationNodes);
        	masterRoot.addChild(i, stationNodes);
        	// <<
    		
    		for(int x=0; x<mapSize; x++){
    			//TreeNodeImpl<String> child = new TreeNodeImpl<String>();
    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
    			
    			String parentNode = mapArr[x].toString();
    			
    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
    			
    			//child.setData(mapObj.getMenuLabel());
    			child.setData(mapObj);
    			
    			stationNodes.addChild(x, child);
    		}
    		// <<
    		
    		masterRoot.addChild(i, stationNodes);
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    ////////// test >>
    public void processExpansion(NodeExpandedEvent evt) {

	  Object source = evt.getSource();
	  if (source instanceof HtmlTreeNode) {
	    UITree tree = ((HtmlTreeNode) source).getUITree();
	    if (tree == null) {
	      return;
	    }
	    // get the row key i.e. id of the given node.
	    Object rowKey = tree.getRowKey();
	    // get the model node of this node.
	    TreeRowKey<?> key = (TreeRowKey<?>) tree.getRowKey();

	    TreeState state = (TreeState) tree.getComponentState();
	    if (state.isExpanded(key)) {
	      System.out.println(rowKey + " - expanded");
	    } else {
	      System.out.println(rowKey + " - collapsed");
	    }
	  }
	}
    ////////// test <<
    
    
    
    
    
    
    
    
    
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
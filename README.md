# MutiAdapter
A simple encapsulation of RecyclerView#Adapter.

## Feature:
1. Special item was supported,
  such as, header,footer,sections,emptyview and more...
   
2. Diff
  with MutiAdapter you can work perfectly with diff.
  
3. RecyclerView-Selection
  Cooperate with RecyclerView-Selection also can be easy.

## Usage:

The core class of MutiAdapter is IViewProvider. 
It is a bridge between Holder&Item. So you can define IViewProvider implementation for each view type.

You can define filter rules that will be applied to original data set.
With filters, you can decide which special items need to be added and where it should be appeared


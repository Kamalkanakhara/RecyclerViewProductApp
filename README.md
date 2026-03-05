Day 4 Task Implemented

Enhancements implemented in the existing RecyclerView project:
- Implemented Navigation Component
- Used SafeArgs to pass Product ID, Name, and Price to the detail screen
- Added proper back navigation
- Refactored the project to follow MVVM Architecture**
- Implemented Repository Pattern

-- MVVM Structure

com.example.recyclerviewproductapp

data/  
  ProductRepository.kt  

ui/  
  ProductListFragment.kt  
  ProductDetailFragment.kt  
  ProductAdapter.kt  

viewmodel/  
  ProductViewModel.kt  

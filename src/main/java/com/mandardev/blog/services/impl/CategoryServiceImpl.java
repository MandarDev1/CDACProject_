package com.mandardev.blog.services.impl;


import com.mandardev.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	createCategory
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelMapper.map(categoryDto,Category.class);
		Category addcat=this.categoryRepo.save(cat);
		return this.modelMapper.map(addcat, CategoryDto.class);
	}

//	updateCategory
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedcat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat,CategoryDto.class);  
	}

	//deleteCategory
	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		this.categoryRepo.delete(cat);
	}

	//getCategory by id
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		
		return this.modelMapper.map(cat,CategoryDto.class);
	}

	//getCategories
	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category>categories=this.categoryRepo.findAll();
		List<CategoryDto>catDtos=  categories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
}

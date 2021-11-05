package WebApplication.AirBnb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import WebApplication.AirBnb.domain.Ratings;
import WebApplication.AirBnb.repository.RatingRepository;
import WebApplication.AirBnb.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService{
	@Autowired
	private RatingRepository repository;

	@Override
	public <S extends Ratings> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public <S extends Ratings> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	@Override
	public Page<Ratings> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public List<Ratings> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Ratings> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<Ratings> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public Optional<Ratings> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public <S extends Ratings> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public <S extends Ratings> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	@Override
	public <S extends Ratings> List<S> saveAllAndFlush(Iterable<S> entities) {
		return repository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Ratings> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Ratings> entities) {
		repository.deleteInBatch(entities);
	}

	@Override
	public <S extends Ratings> long count(Example<S> example) {
		return repository.count(example);
	}

	@Override
	public <S extends Ratings> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Ratings> entities) {
		repository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		repository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Ratings entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		repository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public Ratings getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Ratings> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public Ratings getById(Long id) {
		return repository.getById(id);
	}

	@Override
	public <S extends Ratings> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	@Override
	public <S extends Ratings> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}
	
}

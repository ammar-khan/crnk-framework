package io.crnk.core.mock.repository;

import io.crnk.core.mock.models.Schedule;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;

import java.util.HashMap;
import java.util.Map;

public class ScheduleRepositoryImpl extends ResourceRepositoryBase<Schedule, Long> implements ScheduleRepository {

	private static Map<Long, Schedule> schedules = new HashMap<>();

	public ScheduleRepositoryImpl() {
		super(Schedule.class);
	}

	public static void clear() {
		schedules.clear();
	}

	@Override
	public ScheduleList findAll(QuerySpec querySpec) {
		ScheduleList list = new ScheduleList();
		list.addAll(querySpec.apply(schedules.values()));
		list.setLinks(new ScheduleListLinks());
		list.setMeta(new ScheduleListMeta());
		return list;
	}

	@Override
	public <S extends Schedule> S save(S entity) {
		schedules.put(entity.getId(), entity);
		return null;
	}

	@Override
	public void delete(Long id) {
		schedules.remove(id);
	}
}
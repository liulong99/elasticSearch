package com.tjx.elasticsearch.mapper;

import com.tjx.elasticsearch.bean.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemMapper extends ElasticsearchRepository<Item,String>{



}

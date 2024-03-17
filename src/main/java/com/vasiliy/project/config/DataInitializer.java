package com.vasiliy.project.config;

import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.findAll().isEmpty()) {
            List<Category> categories = new ArrayList<>();

            categories.add(new Category("0010", "Вегетотропные средства"));
            categories.add(new Category("0010-0010", "Адренолитические средства"));
            categories.add(new Category("0010-0010-0010", "Альфа- и бета-адреноблокаторы"));
            categories.add(new Category("0010-0010-0020", "Альфа-адреноблокаторы"));
            categories.add(new Category("0010-0010-0020-0010", "Альфа-адреноблокаторы в комбинациях"));
            categories.add(new Category("0010-0010-0030", "Бета-адреноблокаторы"));
            categories.add(new Category("0010-0010-0030-0010", "Бета-адреноблокаторы в комбинациях"));
            categories.add(new Category("0010-0010-0040", "Симпатолитики"));
            categories.add(new Category("0010-0010-0040-0010", "Симпатолитики в комбинациях"));
            categories.add(new Category("0010-0020", "Адреномиметические средства"));
            categories.add(new Category("0010-0020-0010", "Адрено- и симпатомиметики (альфа-, бета-)"));
            categories.add(new Category("0010-0020-0010-0010", "Адрено- и симпатомиметики (альфа-, бета-) в комбинациях"));
            categories.add(new Category("0010-0020-0020", "Альфа-адреномиметики"));
            categories.add(new Category("0010-0020-0020-0010", "Альфа-адреномиметики в комбинациях"));
            categories.add(new Category("0010-0020-0030", "Бета-адреномиметики"));
            categories.add(new Category("0010-0020-0030-0010", "Бета-адреномиметики в комбинациях"));
            categories.add(new Category("0010-0030", "Холинолитические средства"));
            categories.add(new Category("0010-0030-0010", "м-, н-Холинолитики"));
            categories.add(new Category("0010-0030-0010-0010", "м-Холинолитики"));
            categories.add(new Category("0010-0030-0010-0010-0010", "м-Холинолитики в комбинациях"));
            categories.add(new Category("0010-0030-0020", "н-Холинолитики (ганглиоблокаторы)"));
            categories.add(new Category("0010-0030-0030", "н-Холинолитики (миорелаксанты)"));
            categories.add(new Category("0010-0030-0030-0010", "н-Холинолитики (миорелаксанты) в комбинациях"));
            categories.add(new Category("0010-0040", "Холиномиметические средства"));
            categories.add(new Category("0010-0040-0010", "м-, н-Холиномиметики, в т.ч. антихолинэстеразные средства"));
            categories.add(new Category("0010-0040-0020", "м-Холиномиметики"));
            categories.add(new Category("0010-0040-0020-0010", "м-Холиномиметики в комбинациях"));
            categories.add(new Category("0010-0040-0030", "н-Холиномиметики"));

            categories.add(new Category("0020", "Гематотропные средства"));
            categories.add(new Category("0020-0010", "Антиагреганты"));
            categories.add(new Category("0020-0010-0010", "Антиагреганты в комбинациях"));
            categories.add(new Category("0020-0020", "Антикоагулянты"));
            categories.add(new Category("0020-0020-0010", "Антикоагулянты в комбинациях"));
            categories.add(new Category("0020-0080", "Другие гематотропные средства"));
            categories.add(new Category("0020-0030", "Заменители плазмы и других компонентов крови"));
            categories.add(new Category("0020-0030-0010", "Заменители плазмы и других компонентов крови в комбинациях"));
            categories.add(new Category("0020-0040", "Ингибиторы фибринолиза"));
            categories.add(new Category("0020-0050", "Коагулянты (в т.ч. факторы свертывания крови), гемостатики"));
            categories.add(new Category("0020-0050-0010", "Коагулянты (в т.ч. факторы свертывания крови), гемостатики в комбинациях"));
            categories.add(new Category("0020-0060", "Стимуляторы гемопоэза"));
            categories.add(new Category("0020-0060-0010", "Стимуляторы гемопоэза в комбинациях"));
            categories.add(new Category("0020-0070", "Фибринолитики"));

            categories.add(new Category("0030", "Гомеопатические средства"));

            categories.add(new Category("0040", "Гормоны и их антагонисты"));
            categories.add(new Category("0040-0010", "Андрогены, антиандрогены"));
            categories.add(new Category("0040-0010-0010", "Андрогены, антиандрогены в комбинациях"));
            categories.add(new Category("0040-0020", "Глюкагон и его аналоги"));
            categories.add(new Category("0040-0030", "Гормоны гипоталамуса, гипофиза, гонадотропины и их антагонисты"));
            categories.add(new Category("0040-0030-0010", "Гормоны гипоталамуса, гипофиза, гонадотропины и их антагонисты в комбинациях"));
            categories.add(new Category("0040-0040", "Гормоны щитовидной и паращитовидных желез, их аналоги и антагонисты (включая антитиреоидные средства)"));
            categories.add(new Category("0040-0040-0010", "Гормоны щитовидной и паращитовидных желез, их аналоги и антагонисты в комбинациях"));
            categories.add(new Category("0040-0080", "Другие гормоны, их аналоги и антагонисты"));
            categories.add(new Category("0040-0050", "Инсулины"));
            categories.add(new Category("0040-0050-0010", "Инсулины в комбинациях"));
            categories.add(new Category("0040-0060", "Кортикостероиды"));
            categories.add(new Category("0040-0060-0010", "Глюкокортикостероиды"));
            categories.add(new Category("0040-0060-0010-0010", "Глюкокортикостероиды в комбинациях"));
            categories.add(new Category("0040-0060-0020", "Минералокортикоиды"));
            categories.add(new Category("0040-0070", "Эстрогены, гестагены; их гомологи и антагонисты"));
            categories.add(new Category("0040-0070-0010", "Эстрогены, гестагены; их гомологи и антагонисты в комбинациях"));

            categories.add(new Category("0050", "Диагностические средства"));
            categories.add(new Category("0050-0030", "Другие диагностические средства"));
            categories.add(new Category("0050-0010", "Иммунобиологические диагностические средства"));
            categories.add(new Category("0050-0020", "Контрастные средства"));
            categories.add(new Category("0050-0020-0020", "Магнитно-резонансные контрастные средства"));
            categories.add(new Category("0050-0020-0010", "Рентгеноконтрастные средства"));
            categories.add(new Category("0050-0020-0030", "Ультразвуковые контрастные средства"));

            categories.add(new Category("0060", "Иммунотропные средства"));
            categories.add(new Category("0060-0010", "Вакцины, сыворотки, фаги и анатоксины"));
            categories.add(new Category("0060-0010-0010", "Вакцины, сыворотки, фаги и анатоксины в комбинациях"));
            categories.add(new Category("0060-0150", "Иммуноглобулины"));
            categories.add(new Category("0060-0150-0150", "Иммуноглобулины в комбинациях"));
            categories.add(new Category("0060-0030", "Иммунодепрессанты"));
            categories.add(new Category("0060-0040", "Иммуномодуляторы"));
            categories.add(new Category("0060-0040-0040", "Другие иммуномодуляторы"));
            categories.add(new Category("0060-0040-0040-0010", "Другие иммуномодуляторы в комбинациях"));
            categories.add(new Category("0060-0040-0030", "Индукторы интерферонов"));
            categories.add(new Category("0060-0040-0010", "Интерлейкины"));
            categories.add(new Category("0060-0040-0020", "Интерфероны"));
            categories.add(new Category("0060-0040-0020-0010", "Интерфероны в комбинациях"));

            categories.add(new Category("0070", "Интермедианты"));
            categories.add(new Category("0070-0005", "Агонисты I1-имидазолиновых рецепторов"));
            categories.add(new Category("0070-0010", "Аденозинергические средства"));
            categories.add(new Category("0070-0010-0010", "Аденозинергические средства в комбинациях"));
            categories.add(new Category("0070-0020", "Антагонисты рецепторов ангиотензина II (AT1-подтип)"));
            categories.add(new Category("0070-0020-0010", "Антагонисты рецепторов ангиотензина II (AT1-подтип) в комбинациях"));
            categories.add(new Category("0070-0030", "Гистаминергические средства"));
            categories.add(new Category("0070-0030-0010", "Гистаминолитики"));
            categories.add(new Category("0070-0030-0010-0030", "Стабилизаторы мембран тучных клеток"));
            categories.add(new Category("0070-0030-0020", "Гистаминомиметики"));
            categories.add(new Category("0070-0040", "Дофаминомиметики"));
            categories.add(new Category("0070-0040-0010", "Дофаминомиметики в комбинациях"));
            categories.add(new Category("0070-0070", "Другие интермедианты"));
            categories.add(new Category("0070-0026", "Ингибиторы ФДЭ-5"));
            categories.add(new Category("0070-0050", "Простагландины, тромбоксаны, лейкотриены, их аналоги и антагонисты"));
            categories.add(new Category("0070-0050-0010", "Простагландины, тромбоксаны, лейкотриены их аналоги и антагонисты в комбинациях"));
            categories.add(new Category("0070-0060", "Серотонинергические средства"));
            categories.add(new Category("0070-0060-0010", "Серотонинергические средства в комбинациях"));



            categoryRepository.saveAll(categories);
        }
    }
}
package Sample.hello.Controller;

import Sample.hello.Repository.ItemRepository;
import Sample.hello.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final ItemRepository itemRepository;
    @Autowired
    public MemberController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        itemRepository.save(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model){
        List<Member> members =itemRepository.findAll();
        model.addAttribute("members",members);
        return "members/memberList";
    }


}
